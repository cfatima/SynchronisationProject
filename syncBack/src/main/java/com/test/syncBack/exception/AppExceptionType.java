package com.test.syncBack.exception;

public enum AppExceptionType {

    // Specific Errors 
    
    USER_DOES_NOT_EXIST("001");


    private final String code;

    AppExceptionType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
	
	

}
