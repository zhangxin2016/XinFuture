package com.ratpack.xin.handler;


import com.google.inject.Inject;
import com.ratpack.xin.Test.dbTest;
import com.ratpack.xin.db.tables.pojos.Userinfo;
import com.ratpack.xin.pojo.InfoCommon;
import lombok.extern.log4j.Log4j2;
import org.jooq.*;
import org.jooq.impl.DSL;
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
    @Inject
    private dbTest dbTest;
    @Override
    public void handle(Context ctx) throws Exception {
        //System.out.println("qwe");
        //String id = ctx.getRequest().getQueryParams().get("id");
        //List<InfoCommon.UserInfo.Builder> result = dbTest.list();
        //System.out.println("result:=="+result);
        //String id = "1";
        Table<Record> table = DSL.table("userinfo");//表名
        Result<Record> fetch = dslContext.select().from(table).where("userid = 1").fetch();
        for (Object aResult : fetch) {
            Record record = (Record) aResult;
            System.out.println(record);
        }
        //log.debug("dal getUserfirestwelfare id:{} {}",id,USERINFO);
        ctx.render("zhang");
    }
}
