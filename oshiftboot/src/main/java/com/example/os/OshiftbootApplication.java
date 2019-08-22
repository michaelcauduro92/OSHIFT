package com.example.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OshiftbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OshiftbootApplication.class, args);
	}

}
