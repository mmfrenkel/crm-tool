package com.learning.springdemo.rest;


public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() { 
	}

	public CustomerNotFoundException(String message) {
		super(message); 
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause); 
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause); 
	}

	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace); 
		}

}
