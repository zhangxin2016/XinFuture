package com.ratpack.xin.Test;

import com.google.inject.Inject;
import com.ratpack.xin.config.FutureConfig;
import com.ratpack.xin.db.tables.pojos.Userinfo;
import com.ratpack.xin.guice.FutureModule;
import com.ratpack.xin.guice.provider.DataSourceProvider;
import com.ratpack.xin.main.MainServer;
import lombok.extern.log4j.Log4j2;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.exception.ConfigurationException;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.InvalidResultException;
import org.jooq.exception.TooManyRowsException;
import org.jooq.impl.DSL;
import org.jooq.tools.jdbc.MockCallable;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockRunnable;
import org.jooq.util.xml.jaxb.InformationSchema;
import ratpack.guice.Guice;
import ratpack.registry.Registry;
import ratpack.server.ServerConfigBuilder;


import java.math.BigInteger;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.ratpack.xin.db.tables.Userinfo.USERINFO;

/**
 * Created by zhangx on 2017/8/14
 */
@Log4j2
public class JooqTest {
    @Inject
    private static DSLContext dslContext;
    public static Userinfo selectAll(String id){
        System.out.println("qwe");
        Userinfo userinfo = dslContext.selectFrom(USERINFO).where(USERINFO.USERID.eq(id)).fetchOneInto(Userinfo.class);
        log.debug("dal getUserfirestwelfare id:{} {}",id,USERINFO);
        return userinfo;
    }

}
