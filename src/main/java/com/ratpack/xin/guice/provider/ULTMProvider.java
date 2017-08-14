package com.ratpack.xin.guice.provider;

/**
 * Created by zhangx on 2017/8/14
 * copy from https://github.com/qrman/vertx-guice-jooq-ultm/blob/master/potato-db/src/main/java/io/github/qrman/potato/db/ULTMProvider.java
 */

import com.github.witoldsz.ultm.ULTM;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

public class ULTMProvider implements Provider<ULTM> {
    private final DataSource dataSource;
    @Inject
    public ULTMProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public ULTM get() {
        return new ULTM(dataSource);
    }
}
