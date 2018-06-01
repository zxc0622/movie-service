package com.zxc.movie.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 星驰太帅了 on 2018/06/01.
 * 标记此类在类的上面,便会把所有方法执行时的信息日志到文件中
 * 如某具体方法不需要添加到日志中,那就在该方法上加上 @LogIgnore 即可
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

}
