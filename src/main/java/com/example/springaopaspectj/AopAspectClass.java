package com.example.springaopaspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

 //   all classes all methods under com.example.springaopaspectj.test
 //   first .* represents any class, second one represents any method calls
    @Before("execution(* com.example.springaopaspectj.testpack.*.*(..))")
    public void beforeTestForEveryMethodOnAPackage(JoinPoint joinPoint) {
        logger.info("---> Staring - " + joinPoint.getSignature().getName());
        logger.info("<--- With parameter - " + Arrays.toString(joinPoint.getArgs()));
    }

    //executes for any method call inside this package
//    @Before("execution(* com.example.springaopaspectj..*.*(..))")
//    public void beforeTestForEverythingOnAPackage(JoinPoint joinPoint) {
//        logger.info("---> Staring - " + joinPoint.getSignature().getName());
//        logger.info("<--- With parameter - " + Arrays.toString(joinPoint.getArgs()));
//    }

    //Advice + pointcut ==>> Aspect
    //
    @AfterReturning(value = "execution(* com.example.springaopaspectj.testpack.*.*(..))",
                    returning = "result")
    public void afterTestForEveryMethodOnAPackage(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {} ",joinPoint, result);
    }

    //Logging exceptions
    @AfterThrowing(value = "execution(* com.example.springaopaspectj.testpack.*.*(..))",
            throwing = "exception")
    public void afterThrowingExceptionFromPackage(JoinPoint joinPoint, Exception exception) {
        logger.info("{} throwed {} ", joinPoint, exception);
    }

    //Logs both after returning and after throwing
//    @After(value = "execution(* com.example.springaopaspectj.testpack.*.*(..))")
//    public void afterFromPackage(JoinPoint joinPoint) {
//        logger.info("After execution of {}", joinPoint);
//    }

}
