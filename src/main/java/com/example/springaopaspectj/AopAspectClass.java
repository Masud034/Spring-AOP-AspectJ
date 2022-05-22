package com.example.springaopaspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AopAspectClass {

    Logger logger = LoggerFactory.getLogger(AopAspectClass.class);


    //AopAspectClass method calls
    @Before("execution(* AopControllerClass+.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("(AopControllerClass)**** Staring - " + joinPoint.getSignature().getName());
        logger.info("**** With parameter - " + Arrays.toString(joinPoint.getArgs()));
    }

    //all classes all methods under com.example.springaopaspectj.test
    //first .* represents any class, second one represents any method calls
    @Before("execution(* com.example.springaopaspectj.testpack.*.*(..))")
    public void beforeTestForEveryMethodOnAPackage(JoinPoint joinPoint) {
        logger.info("---> Staring - " + joinPoint.getSignature().getName());
        logger.info("<--- With parameter - " + Arrays.toString(joinPoint.getArgs()));
    }

}
