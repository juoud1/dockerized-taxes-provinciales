package com.dobatii.dockerization1.olibill;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Dockerization1OlibillApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Dockerization1OlibillApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Allo - Olibill service!");
	}

}
