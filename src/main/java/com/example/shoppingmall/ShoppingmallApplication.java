package com.example.shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ShoppingmallApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}
}