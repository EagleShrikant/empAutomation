package com.techmahindra.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.techmahindra"})
public class ExtractApplication {
	
	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(ExtractApplication.class, args);
		 context.getBean(InitialConf.class).init();
	}

}
