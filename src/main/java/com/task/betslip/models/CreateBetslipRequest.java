package com.task.betslip.models;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author sunil
 *
 */
public class CreateBetslipRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Please provide customer Id")
	private Long customerId;
	
	@NotNull(message = "Please provide bet factor for team A")
	@Min(value = 0, message = "Bet factor for team A must be greater than or equal to 0")
	private Double teamAFactor;
	
	@NotNull(message = "Please provide bet factor for tie/draw")
	@Min(value = 0, message = "Bet factor for tie/draw must be greater than or equal to 0")
	private Double tieFactor;
	
	@NotNull(message = "Please provide bet factor for team B")
	@Min(value = 0, message = "Bet factor for team B must be greater than or equal to 0")
	private Double teamBFactor;

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the teamAFactor
	 */
	public Double getTeamAFactor() {
		return teamAFactor;
	}

	/**
	 * @param teamAFactor the teamAFactor to set
	 */
	public void setTeamAFactor(Double teamAFactor) {
		this.teamAFactor = teamAFactor;
	}

	/**
	 * @return the tieFactor
	 */
	public Double getTieFactor() {
		return tieFactor;
	}

	/**
	 * @param tieFactor the tieFactor to set
	 */
	public void setTieFactor(Double tieFactor) {
		this.tieFactor = tieFactor;
	}

	/**
	 * @return the teamBFactor
	 */
	public Double getTeamBFactor() {
		return teamBFactor;
	}

	/**
	 * @param teamBFactor the teamBFactor to set
	 */
	public void setTeamBFactor(Double teamBFactor) {
		this.teamBFactor = teamBFactor;
	}

}
