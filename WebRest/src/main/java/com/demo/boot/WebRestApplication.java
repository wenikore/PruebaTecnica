package com.demo.boot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebRestApplication {
	static final Logger logger = LogManager.getLogger(WebRestApplication.class.getName());

	public static void main(String[] args) {
        logger.info("entered application");
		SpringApplication.run(WebRestApplication.class, args);
	}
}
