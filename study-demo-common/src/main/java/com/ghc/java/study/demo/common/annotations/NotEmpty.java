package com.ghc.java.study.demo.common.annotations;

import java.lang.annotation.*;

/**
 * Created by ghc on 2017/2/15.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotEmpty {
    String value() default "";
}
