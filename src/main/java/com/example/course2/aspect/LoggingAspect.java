package com.example.course2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    //@Before//@After//@AfterThrow//

    @Around("@annotation(com.example.course2.aspect.Transaction)")
    public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Begin Transaction");
        try {
            proceedingJoinPoint.proceed();
            System.out.println("Commit Transaction");
        } catch (Exception e) {
            System.out.println("Rollback Transaction");
        }
        System.out.println(LocalDateTime.now());
        System.out.println();
        System.out.println();
    }
}
