package com.dobatii.dockerization1.provider;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Dockerization1ServiceProviderApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Dockerization1ServiceProviderApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Allo - Olibill provider service!");
		
	}

}
