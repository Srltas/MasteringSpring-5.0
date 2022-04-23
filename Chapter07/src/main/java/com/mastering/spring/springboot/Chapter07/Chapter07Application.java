package com.mastering.spring.springboot.Chapter07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter07Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter07Application.class, args);
	}

}
