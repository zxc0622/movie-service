package com.zxc.movie.aop;

import com.zxc.movie.aop.annotation.LogIgnore;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by 星驰太帅了 on 2018/06/01.
 * 日志切面,所有需要打印日志信息的均使用对应的注解即可
 * @Log 是标记在类上面的,表示拦截该类所有方法,为方法打印日志
 * @LogIgnore 是标记在方法上面的,表示忽略该方法打日志的行为 该注解有2个属性,默认都为false, before即方法前,after即方法外,可以在具体方法标上这个注解,设定某个属性为false，便不会打印方法前或者方法后的属性,出错的日志是无法忽略的!
 * 至于还有其他具体的需求需要打日志,请自行定义日志类,这里只是提供了最基本的日志
 */
@Component
@Aspect
public class LoggingAop{

    private static Logger LOGGER = LoggerFactory.getLogger(LoggingAop.class);

    //拦截所有被该注解修饰的所有类下面的所有方法
    @Around("@within(com.zxc.movie.aop.annotation.Log)")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = null;
        Class<?> clazz = null;
        MethodSignature methodSignature = null;
        try{
            //就是为了获取当前执行的方法,可以忽略不看
            methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            clazz = proceedingJoinPoint.getTarget().getClass();
            Method method =clazz.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
            LogIgnore logIgnore = method.getAnnotation(LogIgnore.class);
            //前置日志
            if(logIgnore == null || logIgnore != null && logIgnore.before()) {
                LOGGER.info(clazz.getName() + " 执行了 " +  methodSignature.getName() + " 方法,参数为{}", Arrays.asList(proceedingJoinPoint.getArgs()));
            }
            object = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            //后置日志
            if(logIgnore == null || logIgnore != null && logIgnore.after()) {
                LOGGER.info(clazz.getName() + " 成功执行了 " +  methodSignature.getName() + " 方法,返回值为{}", object);
            }
        } catch (Throwable e) {
            //异常日志 TODO 后期需要通知对应人员进行一个处理
            LOGGER.error(clazz.getName() + " 执行了 " +  methodSignature.getName() + " 方法出错,当时传入的参数为{}", Arrays.asList(proceedingJoinPoint.getArgs()));
            e.printStackTrace();
        }
        return object;
    }
}

