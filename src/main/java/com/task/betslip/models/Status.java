package com.task.betslip.models;

import java.io.Serializable;

/**
 * @author sunil
 *
 */
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	
	private String type;
	
	private String message;

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
