package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ApiConsumingTestApplication extends SpringBootServletInitializer {

	@RequestMapping(value = "/")
	public String home() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiConsumingTestApplication.class, args);
	}

}
