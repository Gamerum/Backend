package com.gamerum.backend;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log
@EnableCaching
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class Gamerum {

	public static void main(String[] args) {
		SpringApplication.run(Gamerum.class, args);
	}

}
