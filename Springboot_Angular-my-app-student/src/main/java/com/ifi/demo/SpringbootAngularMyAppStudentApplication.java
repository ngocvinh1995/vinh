package com.ifi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ifi")
@EnableJpaRepositories(basePackages = "com.ifi.demo.repo")
@EntityScan(basePackages = "com.ifi.demo.entities")
public class SpringbootAngularMyAppStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngularMyAppStudentApplication.class, args);
	}
}
