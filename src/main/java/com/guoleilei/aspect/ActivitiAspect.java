package com.guoleilei.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ActivitiAspect {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiAspect.class);

    // Pointcut to match the execution of any method in the application
    @Pointcut("execution(* *(..))")
    public void anyMethod() {}

    // Before advice: runs before the execution of any method
    @Before("anyMethod()")
    public void logBefore() {
        logger.info("Method execution started");
    }

    // After advice: runs after the execution of any method
    @After("anyMethod()")
    public void logAfter() {
        logger.info("Method execution completed");
    }

    // Around advice: logs before and after the method execution and captures the method execution time
    @Around("anyMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method {} execution started", methodName);

        Object result = joinPoint.proceed(); // Proceed with the method execution

        logger.info("Method {} execution completed", methodName);
        return result;
    }
}

