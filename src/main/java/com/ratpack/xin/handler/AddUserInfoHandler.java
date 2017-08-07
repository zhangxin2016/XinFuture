package com.ratpack.xin.handler;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.log4j.Log4j2;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import rx.Observable;

import static ratpack.jackson.Jackson.jsonNode;

/**
 * Created by zhangx on 2017/8/7
 */
@Log4j2
public class AddUserInfoHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        log.debug("AddUserInfoHandler begin!");
        Promise<JsonNode> promise = ctx.parse(jsonNode());

    }
}
