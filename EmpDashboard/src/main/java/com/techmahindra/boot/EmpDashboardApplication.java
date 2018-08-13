package com.techmahindra.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.techmahindra"})
public class EmpDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDashboardApplication.class, args);
	}

}
