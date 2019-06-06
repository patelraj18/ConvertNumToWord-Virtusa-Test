package com.virtusa.test;

public class ConvertNumToWordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ConvertNumToWordException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
