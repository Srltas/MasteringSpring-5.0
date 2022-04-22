package com.mastering.spring.springboot.Chapter06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter06Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter06Application.class, args);
	}

}
