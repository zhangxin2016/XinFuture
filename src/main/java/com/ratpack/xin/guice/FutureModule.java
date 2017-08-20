package com.ratpack.xin.guice;

import com.github.witoldsz.ultm.TxManager;
import com.github.witoldsz.ultm.ULTM;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.ratpack.xin.guice.provider.*;
import com.ratpack.xin.handler.AddUserInfoHandler;
import com.ratpack.xin.handler.DeleteUserInfoHandler;
import com.ratpack.xin.handler.GetUserHandler;
import com.ratpack.xin.handler.UpdateUserInfoHandler;
import com.ratpack.xin.router.UserInfoRouter;
import org.jooq.DSLContext;
import ratpack.handling.Handler;

import javax.sql.DataSource;

/**
 * Created by zhangx on 2017/8/4.
 */
public class FutureModule extends AbstractModule {

    @Override
    protected void configure() {

        //路由
        bind(UserInfoRouter.class).in(Singleton.class);
        //handler -> userInfo
        bind(Handler.class).annotatedWith(Names.named("getUserHandler")).to(GetUserHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("addUserInfoHandler")).to(AddUserInfoHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("updateUserInfoHandler")).to(UpdateUserInfoHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("deleteUserInfoHandler")).to(DeleteUserInfoHandler.class).in(Singleton.class);

        //jooq
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(DSLContext.class).toProvider(JooqProvider.class).in(Singleton.class);
        bind(DSLContext.class).annotatedWith(TxJooq.class).toProvider(TxJooqProvider.class).in(Singleton.class);
        bind(ULTM.class).toProvider(ULTMProvider.class).in(Singleton.class);
        bind(TxManager.class).toProvider(TxManagerProvider.class).in(Singleton.class);
    }
}
