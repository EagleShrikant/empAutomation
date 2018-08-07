package com.email.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;


public interface EmailServiceAPI {

	
	public EmailResponse sendSimpleEmail(EmailRequest emailRequest);
	
	@RequestMapping("/withAttachment")
	public EmailResponse sendEmailWithAttachment();
	
}
