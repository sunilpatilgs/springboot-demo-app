package com.task.betslip.models;

import java.io.Serializable;

/**
 * @author sunil
 *
 */
public class BetslipDetailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Betslip betslip;
	
	private Status status;

	/**
	 * @return the betslip
	 */
	public Betslip getBetslip() {
		return betslip;
	}

	/**
	 * @param betslip the betslip to set
	 */
	public void setBetslip(Betslip betslip) {
		this.betslip = betslip;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}
