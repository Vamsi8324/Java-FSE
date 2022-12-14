package com.customerlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerlogin.dto.CustomerLoginDTO;
import com.customerlogin.exception.InfyBankException;
import com.customerlogin.repository.CustomerLoginRepository;
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	
	@Autowired
	CustomerLoginRepository customerLoginRepository;

	@Override
	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws InfyBankException {
		String toReturn = null;
		CustomerLoginDTO customerLoginFromRepository = 
				customerLoginRepository.getCustomerLoginByLoginName(customerLoginDTO.getLoginName());
		if (customerLoginDTO.getPassword().equals(customerLoginFromRepository.getPassword())) {
			toReturn = "SUCCESS";
		} else {
			throw new InfyBankException("Service.WRONG_CREDENTIALS");
		}
		return toReturn;
	}

}
