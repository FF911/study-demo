package com.ghc.java.study.demo.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> </p>
 *
 * @Author : gonghongcai.
 * @Date : 2018/1/6 15:36.
 * @Description :
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NotNull {
    String value() default "";
}
