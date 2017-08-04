package com.ratpack.xin.config;


import com.github.racc.tscg.TypesafeConfig;
import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangx on 2017/8/4.
 */
@Data
@Log4j2
public class FutureConfig {
    @Inject
    @TypesafeConfig("mysqlConfigList")
    private List<MysqlConfig> mysqlConfigList1;

    @Inject
    //@NotNull
    @TypesafeConfig("server.port")
    private Integer serverPort1;


    private final Config config;
    private final Module module;
    private final Injector injector;

    public FutureConfig(File configFile, String scanPath) {
        config = ConfigFactory.parseFile(configFile);
        System.out.println(config);
        module = TypesafeConfigModule.fromConfigWithPackage(config,scanPath);
        injector = Guice.createInjector(module);
        injector.injectMembers(this);
        checkConfig();
    }
    public void checkConfig() {
        try {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<FutureConfig>> validate = validator.validate(this);
            if (validate.size() < 1) {
                return;
            }
            for (ConstraintViolation<FutureConfig> info : validate) {
                log.error("配置信息错误:{}", info.getMessage());
            }
        }catch (Exception e){
            log.error("配置信息错误",e);
        }
    }

}
