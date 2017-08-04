package com.ratpack.xin.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangx on 2017/8/4.
 * mysql配置
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true) //这个注释：不进行json的转化防止一些Json转换异常错误
public class MysqlConfig {

    private String host;

    private Integer port;

    private String username;

    private String password;

    private String database;

    private String table;
}
