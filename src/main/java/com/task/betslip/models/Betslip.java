package com.task.betslip.models;

import java.io.Serializable;

/**
 * @author sunil
 *
 */
public class Betslip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Double teamAFactor;
	
	private Double tieFactor;
	
	private Double teamBFactor;
	
	private String status;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
}
