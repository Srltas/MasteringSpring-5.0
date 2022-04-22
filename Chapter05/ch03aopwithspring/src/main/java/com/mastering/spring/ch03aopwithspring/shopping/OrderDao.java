package com.mastering.spring.ch03aopwithspring.shopping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mastering.spring.ch03aopwithspring.logeverything.LogEverything;

@Repository
public class OrderDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@LogEverything
	public void placeOrder(int value) {
		// Logic goes here
		logger.info("Placed Order - {}", value);
	}
}
