package com.anonymous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.anonymous")
@EnableJpaRepositories(basePackages = "com.anonymous")
@SpringBootApplication
public class AnonymousApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousApplication.class, args);
	}
}
