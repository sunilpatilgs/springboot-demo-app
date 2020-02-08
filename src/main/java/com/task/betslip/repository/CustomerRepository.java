package com.task.betslip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.betslip.domain.Customer;

/**
 * @author sunil
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}
