package com.zx.tvm.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangx on 2017/9/12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAn {

    String value();
}
