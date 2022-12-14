package com.customerlogin;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.customerlogin.JavaConfig;
import com.customerlogin.controller.CustomerLoginController;
import com.customerlogin.dto.CustomerLoginDTO;

public class UserInterface {
	private static final Log LOGGER = LogFactory.getLog(UserInterface.class);
	
	public static void main(String[] args) throws ConfigurationException {
        PropertiesConfiguration config = new Configurations().properties("configuration.properties");
		try {
			
		
		CustomerLoginDTO customerLoginDTO = new CustomerLoginDTO();
		customerLoginDTO.setLoginName("harry");
		customerLoginDTO.setPassword("harry123");
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		CustomerLoginController customerLoginController =applicationContext.getBean(CustomerLoginController.class);
		
		
		
		
		String message = customerLoginController.authenticateCustomer(customerLoginDTO);
		LOGGER.info(config.getProperty(message));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			LOGGER.info(config.getProperty(e.getMessage()));
		}
	}

}
