package com.mastering.spring.ch03aopwithspring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CalculateMethodExecutionTimeAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around(value = "execution(* com.mastering.spring.ch03aopwithspring.shopping.*Dao.*(..))")
	public Object calculateMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object retVal = proceedingJoinPoint.proceed();
		
		long duration = System.currentTimeMillis() - start;
		
		logger.info("Method {} took {} ms to execute", proceedingJoinPoint, duration);
		
		return retVal;
	}
}
