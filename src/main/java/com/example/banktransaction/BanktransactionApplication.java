package com.example.banktransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.banktransaction")
@EnableJpaRepositories(basePackages = "com.example.banktransaction.repository")

public class BanktransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanktransactionApplication.class, args);
	}

}
