package com.aop.zht.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
@Order(-1)
public class LogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution( * com.aop.zht.controller.*Controller.*(..))")
    private void poingCut(){}

    @Before("poingCut()")
    public void before(JoinPoint joinPoint){
        log.info("------------------test 方法执行前-------------------");
        startTime.set(System.currentTimeMillis());
        //接受请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL           : {}", request.getRequestURL().toString());
        log.info("HTTP_METHOD   : " + request.getMethod());
        log.info("IP            : " + request.getRemoteAddr());
        log.info("CLASS_METHOD  : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS          : " + Arrays.toString(joinPoint.getArgs()));
    }
 
    @AfterReturning(returning="ret", pointcut = "poingCut()")
    public void after(Object ret){
        log.info("------------------test 方法执行后-------------------");
        // 处理完请求，返回内容
        log.info("RESPONSE      : " + ret);
        log.info("SPEND TIME    : " + (System.currentTimeMillis() - startTime.get())+"ms");
    }
}