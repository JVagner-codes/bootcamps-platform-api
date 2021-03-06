package com.bootcamps.api.bootcampsplatformapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BootcampsPlatformApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampsPlatformApiApplication.class, args);
	}

}
