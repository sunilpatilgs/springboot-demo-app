package com.task.betslip.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sunil
 *
 */
@Entity
@Table(name = "betslip")
public class Betslip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "factor_team_a", nullable = false)
	private Double teamAFactor;
	
	@Column(name = "factor_tie", nullable = false)
	private Double tieFactor;
	
	@Column(name = "factor_team_b", nullable = false)
	private Double teamBFactor;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cu_id")
	private Customer customer;

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

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
