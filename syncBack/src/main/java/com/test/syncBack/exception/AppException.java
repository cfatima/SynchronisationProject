package com.test.syncBack.exception;

public class AppException extends Exception{

	
	private final AppExceptionType type;
	
	private final String[] args;
	
	public AppException(final AppExceptionType type, final String message) {
		super(message);
		this.type=type;
		this.args=null;
	}
	public AppException(final AppExceptionType type, final String message, final Throwable e) {
		super(message, e);
		this.type=type;
		this.args=null;
	}
	public AppException(final AppExceptionType type, final String message, final String[] args) {
		super(message);
		this.type=type;
		this.args=args;
	}

	public AppExceptionType getType() {
		return type;
	}
	
	public String[] getArgs() {
		return args;
	}
	
}

