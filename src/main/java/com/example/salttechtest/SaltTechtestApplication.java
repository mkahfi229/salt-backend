package com.example.salttechtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SaltTechtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaltTechtestApplication.class, args);
	}

}
