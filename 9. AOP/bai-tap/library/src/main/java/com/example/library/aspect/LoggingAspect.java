package com.example.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private int visitorCount = 0;

    @Pointcut("execution(* com.example.library.service.LibraryService.*(..))")
    public void serviceMethods() {
    }

    @After("serviceMethods()")
    public void logServiceActions(JoinPoint joinPoint) {
        System.out.println("Action executed: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.library.controller.*.*(..))")
    public void countVisitors() {
        visitorCount++;
        System.out.println("Total visitors: " + visitorCount);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void logExceptions(JoinPoint joinPoint, Throwable exception) {
        System.err.println("Exception in method: " + joinPoint.getSignature().getName());
        System.err.println("Exception message: " + exception.getMessage());
    }
}
