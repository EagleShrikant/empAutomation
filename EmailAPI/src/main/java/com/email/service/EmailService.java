package com.email.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;


public interface EmailService {

	public void sendSimpleMessage(String[] to, String subject, String body);
	
	public void sendMessageWithAttachment(
			  String[] to, String subject, String text, String pathToAttachment) throws MessagingException;
}
