package com.shz.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/19 20:52
 * @See com.shz
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Olog {
    String operModule() default "";
    String operType() default "";
    String operDesc() default "";
}
