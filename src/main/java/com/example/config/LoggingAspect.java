package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Incoming request: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example.controller..*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Response: " + result);
    }
}
