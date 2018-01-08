package com.ghc.java.study.demo.common.annotations;

import java.lang.annotation.*;

/**
 * Created by gonghongcai on 2017/3/8.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegValid {
    String value() default "";
    String reg() default "";
}
