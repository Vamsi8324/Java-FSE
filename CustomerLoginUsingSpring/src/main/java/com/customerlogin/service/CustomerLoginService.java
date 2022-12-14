package com.customerlogin.service;

import org.springframework.stereotype.Service;

import com.customerlogin.dto.CustomerLoginDTO;
import com.customerlogin.exception.InfyBankException;
public interface CustomerLoginService {
	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws InfyBankException;

}
