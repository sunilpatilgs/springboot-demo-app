package com.task.betslip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.betslip.domain.Customer;
import com.task.betslip.models.CustomerDetailResponse;
import com.task.betslip.repository.CustomerRepository;

/**
 * @author sunil
 *
 */
@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public CustomerDetailResponse getCustomerDetails(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			CustomerDetailResponse customerDetailResponse = new CustomerDetailResponse();
			customerDetailResponse.setId(customer.get().getId());
			customerDetailResponse.setFirstName(customer.get().getFirstName());
			customerDetailResponse.setLastName(customer.get().getLastName());
			customerDetailResponse.setCity(customer.get().getCity());
			return customerDetailResponse;
		}
		return null;
	}

}
