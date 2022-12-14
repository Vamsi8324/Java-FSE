package com.customerlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.customerlogin.controller.CustomerLoginController;

@Configuration
@ComponentScan
public class JavaConfig {
	@Bean
	public CustomerLoginController getCustomerLoginController() {
		return new CustomerLoginController();
	}
}
