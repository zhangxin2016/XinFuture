package com.ratpack.xin.guice.provider;

/**
 * Created by zhangx on 2017/8/14
 * copy from https://github.com/qrman/vertx-guice-jooq-ultm/blob/master/potato-db/src/main/java/io/github/qrman/potato/db/TxManagerProvider.java on 2016/3/3.
 */

import com.github.witoldsz.ultm.TxManager;
import com.github.witoldsz.ultm.ULTM;

import javax.inject.Inject;
import javax.inject.Provider;

public class TxManagerProvider implements Provider<TxManager> {
    private final ULTM ultm;
    @Inject
    public TxManagerProvider(ULTM ultm) {
        this.ultm = ultm;
    }
    @Override
    public TxManager get() {
        return ultm.getTxManager();
    }
}