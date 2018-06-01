package com.zxc.movie.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 星驰太帅了 on 2018/06/01.
 * 日志忽略注解
 * @before 是否为拦截的方法前打印日记，默认为false
 * @aftr 是否为拦截的方法后打印日记,默认为false
 * 异常时是一定会打印的,因为这个比较严重,后期也可能加入通知机制给后台人员进行处理
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogIgnore {
    boolean before() default false;
    boolean after() default false;
}
