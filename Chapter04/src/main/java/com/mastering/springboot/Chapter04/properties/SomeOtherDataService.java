package com.mastering.springboot.Chapter04.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastering.springboot.Chapter04.Chapter04Application;

@Component
public class SomeOtherDataService {
	
	@Autowired
	private ApplicationConfiguration applicationConfiguration;
	
	public String retrieveSomeData() {
		
		// URL을 사용하고 데이터를 얻는 로직
		Chapter04Application.logger.info(applicationConfiguration.getService1Timeout());
		Chapter04Application.logger.info(applicationConfiguration.getService1Url());
		Chapter04Application.logger.info(applicationConfiguration.isEnableSwitchForService1());
		
		return "data from service";
	}
}
