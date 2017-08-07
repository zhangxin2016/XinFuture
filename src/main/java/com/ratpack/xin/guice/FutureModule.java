package com.ratpack.xin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.ratpack.xin.handler.AddUserInfoHandler;
import com.ratpack.xin.handler.DeleteUserInfoHandler;
import com.ratpack.xin.handler.GetUserHandler;
import com.ratpack.xin.handler.UpdateUserInfoHandler;
import com.ratpack.xin.router.UserInfoRouter;
import ratpack.handling.Handler;

/**
 * Created by zhangx on 2017/8/4.
 */
public class FutureModule extends AbstractModule {

    @Override
    protected void configure() {

        //路由
        bind(UserInfoRouter.class);
        //handler -> userInfo
        bind(Handler.class).annotatedWith(Names.named("getUserHandler")).to(GetUserHandler.class);
        bind(Handler.class).annotatedWith(Names.named("addUserInfoHandler")).to(AddUserInfoHandler.class);
        bind(Handler.class).annotatedWith(Names.named("updateUserInfoHandler")).to(UpdateUserInfoHandler.class);
        bind(Handler.class).annotatedWith(Names.named("deleteUserInfoHandler")).to(DeleteUserInfoHandler.class);
    }
}
