package com.ratpack.xin.guice.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import javax.sql.DataSource;


/**
 * Created by zhangx on 2017/8/14
 * copy from https://github.com/qrman/vertx-guice-jooq-ultm/blob/master/potato-db/src/main/java/io/github/qrman/potato/db/JooqProvider.java
 */
public class JooqProvider implements Provider<DSLContext> {
    private final DataSource dataSource;
    @Inject
    public JooqProvider(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public DSLContext get() {
        Configuration configuration = new DefaultConfiguration()
                .set(dataSource)
                .set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    }
}
