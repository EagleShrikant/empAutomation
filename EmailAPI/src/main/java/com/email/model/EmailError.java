package com.email.model;

import org.springframework.stereotype.Component;

@Component
public class EmailError {
	String errorCode;
	String erroeMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErroeMessage() {
		return erroeMessage;
	}
	public void setErroeMessage(String erroeMessage) {
		this.erroeMessage = erroeMessage;
	}
	
	
}
