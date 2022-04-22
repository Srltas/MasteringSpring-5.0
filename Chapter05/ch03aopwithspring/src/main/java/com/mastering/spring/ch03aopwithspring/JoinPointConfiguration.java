package com.mastering.spring.ch03aopwithspring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JoinPointConfiguration {
	
	@Pointcut("execution(* com.mastering.spring.ch03aopwithspring.shopping.OrderDao.*(..))")
	public void orderDaoExecution() {}
	
	@Pointcut("execution(* com.mastering.spring.ch03aopwithspring.shopping.StockDao.*(..))")
	public void stockDaoExecution() {}
	
	@Pointcut("execution(* com.mastering.spring.ch03aopwithspring.business.*.*(..))")
	public void allBusinessLayerMethods() {}
	
	@Pointcut("execution(* com.mastering.spring.ch03aopwithspring.data.*.*(..))")
	public void allDataLayerMethods() {}
	
	@Pointcut("allBusinessLayerMethods() && allDataLayerMethods()")
	public void methodsFromBusinessAndDataLayers() {}
	
	@Pointcut("@annotation(com.mastering.spring.ch03aopwithspring.logeverything.LogEverything )")
	public void logEverythingAnnoation() {}
}
