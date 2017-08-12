package com.ratpack.xin.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.ratpack.xin.pojo.InfoCommon;
import com.ratpack.xin.tools.JsonTool;
import lombok.extern.log4j.Log4j2;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import rx.Observable;

import java.io.IOException;

import static ratpack.jackson.Jackson.jsonNode;
import static ratpack.rx.RxRatpack.observe;

/**
 * Created by zhangx on 2017/8/7
 */
@Log4j2
public class AddUserInfoHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        log.debug("AddUserInfoHandler begin!");
        Promise<JsonNode> promise = ctx.parse(jsonNode());
        observe(promise).subscribe(bodyJsonNode -> {
            JsonNode userInfoJsonNode = bodyJsonNode.get("userInfo");
            log.debug("AddUserInfoHandler userInfoJsonNode:{}",userInfoJsonNode);
            try {
                InfoCommon.UserInfo userInfo = JsonTool.jsonToObject(userInfoJsonNode,InfoCommon.UserInfo.class);
                log.debug("AddUserInfoHandler userInfo",userInfo);
            } catch (IOException e) {
               log.error("userInfo jsonToObject error:{}",e.getMessage());
            }


        });

    }


}
