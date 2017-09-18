package com.ratpack.xin.guice;

import com.github.witoldsz.ultm.TxManager;
import com.github.witoldsz.ultm.ULTM;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.ratpack.xin.dao.IArticleDao;
import com.ratpack.xin.dao.IArticleTypeDao;
import com.ratpack.xin.dao.impl.ArticleDaoImpl;
import com.ratpack.xin.dao.impl.ArticleTypeDaoImpl;
import com.ratpack.xin.guice.provider.*;
import com.ratpack.xin.handler.*;
import com.ratpack.xin.router.ArticleRouter;
import com.ratpack.xin.router.ArticleTypeChain;
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
        bind(ArticleRouter.class).in(Singleton.class);
        bind(ArticleTypeChain.class).in(Singleton.class);
        //handler -> userInfo
        bind(Handler.class).annotatedWith(Names.named("getUserHandler")).to(GetUserHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("addUserInfoHandler")).to(AddUserInfoHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("updateUserInfoHandler")).to(UpdateUserInfoHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("deleteUserInfoHandler")).to(DeleteUserInfoHandler.class).in(Singleton.class);
        //handler -> 博客
        bind(Handler.class).annotatedWith(Names.named("articleAddHandler")).to(ArticleAddHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("articleListHandler")).to(ArticleListHandler.class).in(Singleton.class);
        bind(Handler.class).annotatedWith(Names.named("articleByUuidHandler")).to(ArticleByUuidHandler.class).in(Singleton.class);

        //jooq
        bind(DataSource.class).toProvider(DataSourceProvider.class).in(Singleton.class);
        bind(DSLContext.class).toProvider(JooqProvider.class).in(Singleton.class);
        bind(DSLContext.class).annotatedWith(TxJooq.class).toProvider(TxJooqProvider.class).in(Singleton.class);
        bind(ULTM.class).toProvider(ULTMProvider.class).in(Singleton.class);
        bind(TxManager.class).toProvider(TxManagerProvider.class).in(Singleton.class);

        //DAO
        bind(IArticleDao.class).to(ArticleDaoImpl.class).in(Singleton.class);
        bind(IArticleTypeDao.class).to(ArticleTypeDaoImpl.class).in(Singleton.class);
    }
}
