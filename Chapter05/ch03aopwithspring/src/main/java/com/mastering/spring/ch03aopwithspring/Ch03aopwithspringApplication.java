package com.mastering.spring.ch03aopwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mastering.spring.ch03aopwithspring.shopping.ShoppingService;

@SpringBootApplication
public class Ch03aopwithspringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Ch03aopwithspringApplication.class, args);
		
		ShoppingService service = ctx.getBean(ShoppingService.class);
		
		service.checkAndPlaceOrder();
	}

}
