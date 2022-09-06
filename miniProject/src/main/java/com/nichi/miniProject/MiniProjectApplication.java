package com.nichi.miniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.nichi.miniProject.config","com.nichi.miniProject.exceptions", "com.nichi.miniProject.services", "com.nichi.miniProject.repositries", "com.nichi.miniProject.controller" ,"com.nichi.miniProject.model"})
@EnableJpaRepositories(basePackages = { "com.nichi.miniProject.repositries" })
@SpringBootApplication
public class MiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

}
