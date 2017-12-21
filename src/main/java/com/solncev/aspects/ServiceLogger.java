package com.solncev.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Марат on 30.05.2017.
 */
@Aspect
@Component
public class ServiceLogger {
    private static Logger logger = Logger.getLogger(ServiceLogger.class);

    @After("execution(* com.solncev.controller.SignUpController.SignUp())")
    public void logAfterSignUp() {
        logger.info("User signed up");
    }

    @Before("execution(* com.solncev.service.*.*(..))")
    public void before() {
        logger.info("Service method is being executed..");
    }
}
