package com.task.betslip.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.betslip.models.BetslipDetailResponse;
import com.task.betslip.models.CreateBetslipRequest;
import com.task.betslip.models.Status;

/**
 * @author sunil
 *
 */
@RequestMapping(path = "/api/v1/betslip")
@Api(description = "Betslip API")
public interface BetslipAPI {

	@GetMapping(value = "/{betId}")
	@ApiOperation(value = "Get Betslip Details", response = BetslipDetailResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public BetslipDetailResponse getBetslipDetails(Long betId);
	
	@PostMapping(value = "/create")
	@ApiOperation(value = "Create Betslip", response = Status.class)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "CREATED")})
	public ResponseEntity<Status> createBetslip(CreateBetslipRequest betslipRequest);
	
	@PutMapping(value = "/update/{betId}")
	@ApiOperation(value = "Update Betslip", response = Status.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public ResponseEntity<Status> updateBetslip(Long betId, CreateBetslipRequest betslipRequest);
	
	@DeleteMapping(value = "/{betId}")
	@ApiOperation(value = "Delete Betslip", response = Status.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	public ResponseEntity<Status> deleteBetslip(Long betId);
}
