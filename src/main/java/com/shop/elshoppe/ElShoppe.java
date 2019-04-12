package com.shop.elshoppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.shop.elshoppe.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ElShoppe {

	public static void main(String[] args) {
		SpringApplication.run(ElShoppe.class, args);
	}
}