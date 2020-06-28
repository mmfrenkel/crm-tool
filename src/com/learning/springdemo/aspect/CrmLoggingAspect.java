package com.learning.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CrmLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// run for any class, any method with any number of args
	@Pointcut("execution(* com.learning.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.learning.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("execution(* com.learning.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	// this should match on anything in any package
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	private void beforeLogging(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("===> @Before, calling method: " + method);
		
		// display arguments to the method
		Object[] args = joinPoint.getArgs();
		
		for (Object arg: args) {
			logger.info("===> argument: " + arg);
		}
		
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	private void afterLogging(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("===> @AfterReturning, calling method: " + method);
		
		// display arguments to the method
		logger.info("===> result: " + result);
		
	}

}
