package com.cg.test.exception;

public class UserException extends Exception {

	String exceptionMessage;
	public UserException() {
	}
	
		public UserException(String exceptionMessage) {
			super(exceptionMessage);
			
		}
}
