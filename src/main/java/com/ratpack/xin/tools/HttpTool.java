package com.ratpack.xin.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangx on 2017/9/1
 * copy to caoqingguang
 */
@Log4j2
public abstract class HttpTool {
    private static final MediaType JSON=MediaType.parse("application/json");
    private static final OkHttpClient client;
    static {
        Dispatcher dispatcher = new Dispatcher(ThreadPools.getExecutor("http-thread", 100));
        dispatcher.setMaxRequests(100);
        dispatcher.setMaxRequestsPerHost(80);
        ConnectionPool pool = new ConnectionPool(5, 10, TimeUnit.MINUTES);
        client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES)
                .followRedirects(true)
                .readTimeout(3, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .writeTimeout(3, TimeUnit.MINUTES)
                .connectionPool(pool)
                .dispatcher(dispatcher)
                .build();
    }

    public static CompletableFuture<JsonNode> getJson(String url){
        return getWithFunc(url,JsonTool::strToJsonNode);
    }
    public static <T> CompletableFuture<T> getWithFunc(String url, Function<String, T> function){
        return commomRequest(url,false,null,function);
    }
    private static <T> CompletableFuture<T> commomRequest(String url,boolean post,Object postData,Function<String,T> func){
        CompletableFuture<T> future = new CompletableFuture<T>();
        try {
            Request request = null;
            if(post){
                request = new Request.Builder().url(url).post(RequestBody.create(JSON, postData.toString())).build();
            } else {
                request = new Request.Builder().url(url).build();
            }

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    future.completeExceptionally(e);
                    log.info("url_req error, url={},method={},reqData={},responData={}", url, post ? "post" : "get", postData, e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if(response.isSuccessful()){
                            String string = response.body().string();
                            T result = func.apply(string);
                            future.complete(result);
                            log.info("url_req seccess, url={}, method={}, reqData={}, responData={}", url, post ? "post" : "get", postData, string);
                        }else{
                            String msg=String.format("url:%s, response_code:%s",url,response.code());
                            response.body().string();
                            future.completeExceptionally(new RuntimeException(msg));
                            log.info("url_req error, url={}, method={}, reqData={}, responCode={}", url, post ? "post" : "get", postData, response.code());
                        }
                    } catch (Exception e) {
                        future.completeExceptionally(e);
                        log.info("url_req error, url={}, method={}, reqData={}, responData={}", url, post ? "post" : "get", postData, e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
            log.info("url_req error, url={}, method={}, reqData={}, responData={}", url, post ? "post" : "get", postData, e.getMessage());
        }
        return future;
    }
}
