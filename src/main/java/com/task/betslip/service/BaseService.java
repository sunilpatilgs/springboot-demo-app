package com.task.betslip.service;

import com.task.betslip.models.Status;
import com.task.betslip.status.BetslipStatus;

/**
 * @author sunil
 *
 */
public abstract class BaseService {

	/**
	 * Method creates the Status
	 * @param betslipStatus BetslipStatus
	 * @return Status
	 */
	protected Status createSatus(BetslipStatus betslipStatus) {
		Status status = new Status();
		status.setCode(betslipStatus.getCode());
		status.setType(betslipStatus.getType());
		status.setMessage(betslipStatus.getMessage());
		return status;
	}
}
