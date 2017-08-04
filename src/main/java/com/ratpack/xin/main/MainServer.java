package com.ratpack.xin.main;

import com.ratpack.xin.config.FutureConfig;
import lombok.extern.log4j.Log4j2;
import ratpack.server.RatpackServer;

import java.nio.file.Paths;

/**
 * Created by zhangx on 2017/8/3.
 */
@Log4j2
public class MainServer {
    private static FutureConfig futureConfig;
    public static void main(String[] args) {
        futureConfig = new FutureConfig(Paths.get("config.conf").toFile(),"com.ratpack.xin");
        log.info("asd");
        System.out.println("hello future");
    }

}
