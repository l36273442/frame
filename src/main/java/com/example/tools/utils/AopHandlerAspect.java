package com.example.tools.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopHandlerAspect {
    //private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.example.tools.controller.*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void afterAction(JoinPoint joinPoint) throws Throwable {

    }
}

