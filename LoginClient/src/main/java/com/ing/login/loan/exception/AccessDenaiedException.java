package com.ing.login.loan.exception;

public class AccessDenaiedException extends RuntimeException {
	
private static final long serialVersionUid=1L;
	
	public AccessDenaiedException(String message,Throwable cause) {
		super(message,cause);
		
	}
	public AccessDenaiedException(Throwable cause) {
		super(cause);
		
	}
	

}
