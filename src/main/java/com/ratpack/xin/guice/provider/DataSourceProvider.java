package com.ratpack.xin.guice.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.ratpack.xin.config.MysqlConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;

import javax.sql.DataSource;

/**
 * Created by Xin on 2017/8/9.
 */
@Log4j2
public class DataSourceProvider implements Provider<DataSource> {
    @Inject
    private MysqlConfig mysqlConfig;
    @Override
    public DataSource get() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDataSourceClassName(mysqlConfig.getDataSourceClassName());
        hikariConfig.setJdbcUrl(mysqlConfig.getUrl());
        hikariConfig.setUsername(mysqlConfig.getUsername());
        hikariConfig.setPassword(mysqlConfig.getPassword());
        hikariConfig.addDataSourceProperty("databaseName",mysqlConfig.getDatabase());
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

}
