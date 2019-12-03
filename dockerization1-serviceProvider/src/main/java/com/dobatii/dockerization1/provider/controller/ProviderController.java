package com.dobatii.dockerization1.provider.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.dobatii.dockerization1.provider.data.Provider;
import com.dobatii.dockerization1.provider.data.Province;
import com.dobatii.dockerization1.provider.service.ProviderService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Composant d'intéraction avec tout client du service-provider
 * 
 * @author 9386-2142 Qc inc
 * @version 1.0
 * 2019-05-12
 * 
 */

@RestController
@Slf4j
public class ProviderController {
	
	private final ProviderService providerService;
	
	public ProviderController(ProviderService providerService) {
		this.providerService = providerService;
	}
	
	@GetMapping("/providers")
	public Optional<List<Provider>> getProviders(){
		List<Province>  provinces = WebClient.create()
										.method(HttpMethod.GET)
										.uri("localhost:8888/provinces2")
										.contentType(MediaType.APPLICATION_JSON_UTF8)
										.retrieve()
										.bodyToFlux(Province.class)
										.collectList()
										.block();
		
		log.info("provinces :\n {}".toUpperCase(), provinces.toString());
		
		log.info("providers :\n {}".toUpperCase(), providerService.getProviders(provinces.get(0))
				.collectList()
				.block()
				.toString());
		
		return providerService.getProviders(provinces.get(0))
				.collectList()
				.blockOptional();
	}
}
