package com.task.betslip.service;

import com.task.betslip.models.CustomerDetailResponse;

/**
 * @author sunil
 *
 */
public interface CustomerService {

	public CustomerDetailResponse getCustomerDetails(Long customerId);
}
