package com.ratpack.xin.handler;


import com.google.inject.Inject;
import com.ratpack.xin.db.tables.pojos.Userinfo;
import com.ratpack.xin.tools.JsonTool;
import lombok.extern.log4j.Log4j2;
import org.jooq.*;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.List;

import static com.ratpack.xin.db.tables.Userinfo.USERINFO;
import static ratpack.jackson.Jackson.json;

/**
 * Created by zhangx on 2017/8/7
 */
@Log4j2
public class GetUserHandler implements Handler {
    @Inject
    private static DSLContext dslContext;
    @Inject
    public GetUserHandler(DSLContext dslContext) {
        this.dslContext = dslContext;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        List<Userinfo> userinfoList = dslContext.selectFrom(USERINFO).fetch().map(record -> {
            Userinfo userinfo = record.into(Userinfo.class);
            return userinfo;
        });
        ctx.getResponse().getHeaders().add("content-type","application/json;charset=UTF-8");
        ctx.render(json(JsonTool.createObjectNode().put("status",1).set("result",JsonTool.readJsonNodeValue(userinfoList))));


    }
}
