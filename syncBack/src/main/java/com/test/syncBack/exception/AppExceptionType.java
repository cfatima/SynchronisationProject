package com.test.syncBack.exception;

public enum AppExceptionType {
	
	// General Errors
	
    TIMEOUT("996","app.error.996.msg"),
    SYSTEM_ERROR("999", "app.error.999.msg"),
    

    // Specific Errors 
    
    USER_DOES_NOT_EXIST("001");


    private final String code;
    private final String msgKey;

    AppExceptionType(final String code) {
        this.code = code;
        this.msgKey = null;
    }

    AppExceptionType(final String code, final String msgKey) {
        this.code = code;
        this.msgKey = msgKey;
    }

    public String getCode() {
        return code;
    }

    public String getMsgKey() {
        return msgKey;
    }
	
	

}
