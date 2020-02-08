package com.task.betslip.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.betslip.models.CustomerDetailResponse;

/**
 * @author sunil
 *
 */
@RequestMapping(path = "/api/v1/customer")
@Api(description = "Customer API")
public interface CustomerAPI {

	@GetMapping(value = "/{customerId}")
	@ApiOperation(value = "Get Customer Details", response = CustomerDetailResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public CustomerDetailResponse getCustomerDetails(Long customerId);
}
