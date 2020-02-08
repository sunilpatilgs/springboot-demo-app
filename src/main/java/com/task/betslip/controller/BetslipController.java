package com.task.betslip.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.betslip.api.BetslipAPI;
import com.task.betslip.models.BetslipDetailResponse;
import com.task.betslip.models.CreateBetslipRequest;
import com.task.betslip.models.Status;
import com.task.betslip.service.BetslipService;

/**
 * @author sunil
 *
 */
@RestController
public class BetslipController implements BetslipAPI {
	
	private BetslipService betslipService;
	
	@Autowired
	public BetslipController(BetslipService betslipService) {
		this.betslipService = betslipService;
	}

	@Override
	public BetslipDetailResponse getBetslipDetails(@PathVariable(name = "betId", required = true) Long betId) {
		return betslipService.getBetslipDetails(betId);
	}
	
	@Override
	public ResponseEntity<Status> createBetslip(@Valid @RequestBody CreateBetslipRequest betslipRequest) {
		return new ResponseEntity<>(betslipService.createBetslip(betslipRequest), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Status> deleteBetslip(@PathVariable(name = "betId", required = true) Long betId) {
		return new ResponseEntity<>(betslipService.deleteBetslip(betId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Status> updateBetslip(@PathVariable(name = "betId", required = true)Long betId, @Valid @RequestBody CreateBetslipRequest betslipRequest) {
		return new ResponseEntity<>(betslipService.updateBetslip(betId, betslipRequest), HttpStatus.OK);
	}

}
