package com.zx.tvm.asynchronous;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangx on 2017/9/1
 */
public class GuavaTest {

    public static void main(String[] args) {
        futureTest();
    }

    public static void futureTest(){
        System.out.println("aaa"+Thread.currentThread());
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));
        ListenableFuture listenableFuture = service.submit(new Callable() {
            @Override
            public String call() throws InterruptedException {
                Thread.sleep(2000);
                return "tvm";
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback() {
            @Override
            public void onSuccess(@Nullable Object result) {
                try {
                    System.out.println(listenableFuture.get()+":"+Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                listenableFuture.addListener(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("asd"+":"+Thread.currentThread());
                    }
                },Executors.newFixedThreadPool(1));
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("tvm2");
            }
        },Executors.newFixedThreadPool(1));
    }

}
