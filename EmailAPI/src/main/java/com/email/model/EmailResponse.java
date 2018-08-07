package com.email.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmailResponse {
	String statusCode;
	String message;
	List<EmailError> errors;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<EmailError> getErrors() {
		return errors;
	}
	public void setErrors(List<EmailError> errors) {
		this.errors = errors;
	}
	
}
