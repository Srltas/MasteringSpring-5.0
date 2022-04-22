package com.mastering.spring.ch03aopwithspring.logeverything;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogEverythingAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.mastring.spring.ch03aopwithspring.JoinPointConfiguration.logEverythingAnnoation()")
	public Object calculateMethodExcutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("Method {} started execution", proceedingJoinPoint);
		logger.info("Method {} arguments are {}", proceedingJoinPoint, proceedingJoinPoint.getArgs());
		
		Object retVal = proceedingJoinPoint.proceed();
		logger.info("Method {} completed execution", proceedingJoinPoint);
		
		return retVal;
	}
}
