package com.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lab.controller", "com.lab.service","com.lab.config"})
public class AWSS3Application {

	public static void main(String[] args) {
		SpringApplication.run(AWSS3Application.class, args);
	}

}
