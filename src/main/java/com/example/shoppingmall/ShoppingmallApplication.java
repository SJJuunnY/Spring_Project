package com.example.shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ServletComponentScan
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@ConfigurationProperties("app.datasource")
@EnableJpaRepositories
public class ShoppingmallApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}
}