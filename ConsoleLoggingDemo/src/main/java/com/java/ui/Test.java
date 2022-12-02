package com.java.ui;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.java.service.UserAuthentication;

public class Test {
	private static final Log LOGGER = LogFactory.getLog(Test.class);
	public static void main(String[] args) {
		try {
			UserAuthentication authentication = new UserAuthentication();
			authentication.loginUser("Jon", "Asdf@123");
			LOGGER .info("User has logged in successfully");
		} catch(Exception exception) {
			LOGGER .info(exception.getMessage());
		}
	}
}

