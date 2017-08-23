package com.ratpack.xin.handler;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.ratpack.xin.pojo.InfoCommon;
import com.ratpack.xin.tools.JsonTool;
import lombok.extern.log4j.Log4j2;
import org.jooq.*;
import org.jooq.impl.DSL;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.ArrayList;
import java.util.List;

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
        try {
            Table<Record> table = DSL.table("userinfo");//表名
            Result<Record> fetch = dslContext.select().from(table).where("userid = 1").fetch();
            List<InfoCommon.UserInfo.Builder> userInfoBuilderList = new ArrayList<>();
            for (Object aResult : fetch) {
                InfoCommon.UserInfo.Builder userInfoBuilder = InfoCommon.UserInfo.newBuilder();
                Record record = (Record) aResult;
                System.out.println(record.getValue(1));
                userInfoBuilder.setUserid(record.getValue(0).toString());
                userInfoBuilder.setUsername(record.getValue("username").toString());
                userInfoBuilder.setUserpassword(record.getValue(2).toString());
                userInfoBuilder.setUserphone(record.getValue(3).toString());
                userInfoBuilder.setUsersex(record.getValue(4).toString());
                userInfoBuilder.setUsercountry(record.getValue(5).toString());
                userInfoBuilder.setUserprovince(record.getValue(6).toString());
                userInfoBuilder.setUsercity(record.getValue(7).toString());
                userInfoBuilder.setUserarea(record.getValue(8).toString());
                userInfoBuilder.setUsercreatetime(record.getValue(9).toString());
                userInfoBuilder.setUserhead(record.getValue(10).toString());
                userInfoBuilder.setQqid(record.getValue(11).toString());
                userInfoBuilder.setWxid(record.getValue(12).toString());
                userInfoBuilderList.add(userInfoBuilder);
            }
            System.out.println(userInfoBuilderList);
            ctx.getResponse().getHeaders().add("content-type","application/json;charset=UTF-8");
            ctx.render(json(JsonTool.createObjectNode().put("status",1).set("result",JsonTool.readJsonNodeValue(userInfoBuilderList))));
        }catch (Exception e){
            log.error("错误:{}",e);
            ctx.getResponse().getHeaders().add("content-type","application/json;charset=UTF-8");
            ctx.render(json(JsonTool.createObjectNode().put("result","获取列表异常").put("status",-1)));
        }

    }
}
