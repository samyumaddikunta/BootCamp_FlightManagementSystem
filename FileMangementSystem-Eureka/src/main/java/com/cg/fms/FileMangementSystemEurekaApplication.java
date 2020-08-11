package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class FileMangementSystemEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileMangementSystemEurekaApplication.class, args);
	}

}
