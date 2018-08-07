package com.email.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties\\emailProperty.properties")
public class EmailConstants {

	@Value( "${email_successful_msg}" )
	public String EMAIL_SUCCESSFUL_MSG;

	public String getEmailSuccessfulMsg() {
		return EMAIL_SUCCESSFUL_MSG;
	}
	
}
