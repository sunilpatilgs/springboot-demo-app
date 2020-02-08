package com.task.betslip.service;

import javax.validation.Valid;

import com.task.betslip.models.BetslipDetailResponse;
import com.task.betslip.models.CreateBetslipRequest;
import com.task.betslip.models.Status;

/**
 * @author sunil
 *
 */
public interface BetslipService {

	public BetslipDetailResponse getBetslipDetails(Long betId);

	public Status deleteBetslip(Long betId);

	public Status createBetslip(@Valid CreateBetslipRequest betslipRequest);

	public Status updateBetslip(Long betId, @Valid CreateBetslipRequest betslipRequest);
}
