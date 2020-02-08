package com.task.betslip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.task.betslip.api.CustomerAPI;
import com.task.betslip.models.CustomerDetailResponse;
import com.task.betslip.service.CustomerService;

/**
 * @author sunil
 *
 */
@RestController
public class CustomerController implements CustomerAPI {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public CustomerDetailResponse getCustomerDetails(@PathVariable(value = "customerId", required = true) Long customerId) {
		return customerService.getCustomerDetails(customerId);
	}
}
