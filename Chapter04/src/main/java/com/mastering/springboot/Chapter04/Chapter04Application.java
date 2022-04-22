package com.mastering.springboot.Chapter04;

import java.util.Arrays;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.mastering.springboot.Chapter04.properties.SomeDataService;
import com.mastering.springboot.Chapter04.properties.SomeOtherDataService;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Chapter04Application {
	
	public static Logger logger = Logger.getLogger(Chapter04Application.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Chapter04Application.class, args);
		
		// Spring Application Context에 정의된 모든 빈
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		
//		for (String beanName : beanNames) {
//			logger.info(beanName);
//		}
		
		SomeDataService dataService = ctx.getBean(SomeDataService.class);
		SomeOtherDataService someOtherDataService =  ctx.getBean(SomeOtherDataService.class);
		
		logger.info("현재 적용된 cache : "+ ctx.getBean("cache"));
		
		logger.info(dataService.retrieveSomeData());
		logger.info(someOtherDataService.retrieveSomeData());
	}

}
