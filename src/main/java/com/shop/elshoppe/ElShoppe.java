package com.shop.elshoppe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.shop.elshoppe.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ElShoppe {
	
	private static final Logger logger = LoggerFactory.getLogger(ElShoppe.class);

	public static void main(String[] args) {
		logger.info("Inside ElShoppe main : Started ElShoppe application");
		SpringApplication.run(ElShoppe.class, args);
	}
}
