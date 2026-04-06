package com.robin.demo.taller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TallerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TallerApplication.class, args);
		/*
		String password = "123456";
		System.out.println("Encoded password: " + new BCryptPasswordEncoder().encode(password));
		//$2a$10$5k0fGqIdt/huRrt7tLOxBu7y36IMh6SL6GY0YKGpVcUQEmS01a79C
		*/
	}

}
