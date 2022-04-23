package com.mastering.spring.springboot.Chapter07.bean;

public class TodoNotFoundException extends RuntimeException {
	public TodoNotFoundException(String msg) {
		super(msg);
	}
}
