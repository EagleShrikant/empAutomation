package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.constants.EmailConstants;
import com.email.model.EmailError;
import com.email.model.EmailRequest;
import com.email.model.EmailResponse;

@RestController
@RequestMapping("/email")
public class EmailServiceAPIImpl implements EmailServiceAPI{

	@Autowired
	EmailResponse emailResponse;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	EmailError emailError;
	
	@Autowired
	EmailConstants emailConstants;
	
	@PostMapping("/simple")
	public EmailResponse sendSimpleEmail(@RequestBody EmailRequest emailRequest) {
		System.out.println("Inside sendSimple Email");
		try{
		emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
		emailResponse.setMessage(emailConstants.EMAIL_SUCCESSFUL_MSG);
		emailResponse.setStatusCode("200");
		}catch(MailException me){
			System.out.println("Inside sendSimple Email Exception" + me);
			emailResponse.setMessage(emailConstants.EMAIL_SUCCESSFUL_MSG);
			emailResponse.setStatusCode("1001");
			emailError.setErrorCode("1001");
			emailError.setErroeMessage("Error in sending Mail");
			//			emailResponse.setErrors(emailError);
		}
		
		return emailResponse;
	}

	public EmailResponse sendEmailWithAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

}
