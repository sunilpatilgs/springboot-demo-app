package com.task.betslip.status;

/**
 * @author sunil
 *
 */
public enum BetslipStatus {
	
	CREATION_SUCCESS(0, "info", "Betslip created Successfuly!!!"),
	
	DELETE_SUCCESS(0, "info", "Betslip deleted Successfuly!!!"),
	
	UPDATE_SUCCESS(0, "info", "Betslip updated Successfuly!!!"),
	
	CUSTOMER_NOT_FOUND(1, "warn", "Customer not found"),
	
	BETSLIP_NOT_FOUND(2, "warn", "Betslip not found!!!"),
	
	CREATION_FAILED(10, "error", "Error While creating Betslip!!!"),
	
	UPDATE_FAILED(11, "error", "Error While deleting Betslip!!!"),
	
	DELETE_FAILED(12, "error", "Error While deleting Betslip!!!");
	
	/**
	 * 
	 * @param code
	 * @param type
	 * @param message
	 */
	BetslipStatus(int code, String type, String message){
		this.code = code;
		this.type = type;
		this.message = message;
	}
	
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
