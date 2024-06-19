package com.bus.booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//Marks the class as a spring Boo application and it includes other annotations like '@Configration','EnableAutoConfiguration' and'SpringApplication.run'
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.*")
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
