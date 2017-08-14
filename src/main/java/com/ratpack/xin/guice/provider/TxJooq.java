package com.ratpack.xin.guice.provider;

/**
 * copy from https://github.com/qrman/vertx-guice-jooq-ultm/blob/master/potato-db/src/main/java/io/github/qrman/potato/db/TxJooq.java
 */
import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
public @interface TxJooq {

}
