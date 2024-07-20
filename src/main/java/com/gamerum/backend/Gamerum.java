package com.gamerum.backend;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Log
@EnableCaching
@SpringBootApplication
public class Gamerum {

	public static void main(String[] args) {
		SpringApplication.run(Gamerum.class, args);
	}

}
