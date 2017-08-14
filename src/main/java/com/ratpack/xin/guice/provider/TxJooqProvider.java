package com.ratpack.xin.guice.provider;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import javax.inject.Inject;
import javax.inject.Provider;

import com.github.witoldsz.ultm.ULTM;
/**
 * Created by zhangx on 2017/8/14
 * copy from https://github.com/qrman/vertx-guice-jooq-ultm/blob/master/potato-db/src/main/java/io/github/qrman/potato/db/TxJooqProvider.java
 */
public class TxJooqProvider implements Provider<DSLContext> {

    private final ULTM ultm;

    @Inject
    public TxJooqProvider(ULTM ultm) {
        this.ultm = ultm;
    }

    @Override
    public DSLContext get() {
        Configuration configuration = new DefaultConfiguration()
                .set(ultm.getManagedDataSource())
                .set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    }
}
