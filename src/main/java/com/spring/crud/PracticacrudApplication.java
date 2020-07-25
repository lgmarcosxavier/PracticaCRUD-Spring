package com.spring.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.spring.crud.modelo")
public class PracticacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticacrudApplication.class, args);
	}

}
