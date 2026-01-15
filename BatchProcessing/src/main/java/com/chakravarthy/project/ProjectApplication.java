package com.chakravarthy.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
//@ComponentScan({"com.model.response_model.*","com.model.request_model.*","com.transformer.*"})
//@EnableScheduling
public class ProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectApplication.class, args);
	}

}
