package com.ratpack.xin.main;

import com.ratpack.xin.config.FutureConfig;
import com.ratpack.xin.guice.FutureModule;
import com.ratpack.xin.renders.ResultRender;
import com.ratpack.xin.router.UserInfoRouter;
import com.sun.net.httpserver.Filter;
import lombok.extern.log4j.Log4j2;
import ratpack.guice.Guice;
import ratpack.handling.Chain;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfigBuilder;

import java.nio.file.Paths;

/**
 * Created by zhangx on 2017/8/3.
 */
@Log4j2
public class MainServer {
    private static FutureConfig futureConfig;
    public static void main(String[] args) throws Exception {
        futureConfig = new FutureConfig(Paths.get("config.conf").toFile(),"com.ratpack.xin");
        log.info("asd");
        RatpackServer.start(rss->{
            rss.serverConfig(MainServer::initConfig)
                    .registry(MainServer.registryFunction())
                    .handlers(MainServer::router);
        });
    }
    public static ServerConfigBuilder initConfig(ServerConfigBuilder serverConfigBuilder){
        return serverConfigBuilder.port(futureConfig.getServerPort()).baseDir(Paths.get(futureConfig.getStaticFilePath()));
    }

    public static Registry registryFunction(){
        return Guice.registry(futureConfig.getInjector().createChildInjector(new FutureModule()));
    }

    public static void router(Chain chain) throws Exception {
        chain.register(registrySpec ->
                registrySpec.add(new ResultRender())).all(context -> {
                    context.getResponse().getHeaders()
                            .add("Access-Control-Allow-Origin", "*")
                            .add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE")
                            .add("Access-Control-Max-Age", 86400)
                            .add("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
                    context.next();
        }).get(context->{
            context.render("This is XinFuture project");
        }).prefix("userInfo",UserInfoRouter.class)
          .files();
    }
}
