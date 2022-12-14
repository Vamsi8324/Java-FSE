package com.customerlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.customerlogin.dto.CustomerLoginDTO;
import com.customerlogin.exception.InfyBankException;
import com.customerlogin.service.CustomerLoginService;

public class CustomerLoginController {
	@Autowired
	private CustomerLoginService customerLoginService;

	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws InfyBankException {
		return customerLoginService.authenticateCustomer(customerLoginDTO);
}
}