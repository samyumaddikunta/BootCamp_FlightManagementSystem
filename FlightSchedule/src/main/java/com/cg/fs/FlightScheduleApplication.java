package com.cg.fs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class FlightScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightScheduleApplication.class, args);
	}

}
