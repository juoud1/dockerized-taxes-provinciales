package com.dobatii.dockerization1.provider.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.dobatii.dockerization1.provider.data.Provider;
import com.dobatii.dockerization1.provider.data.Province;

import reactor.core.publisher.Flux;

/**
 * 
 * @author 9386-2142 Qc inc
 * @version 1.0
 * 2019-05-12
 * 
 */

@Service
public class ProviderService {
	
	public Flux<Provider> getProviders(){
		Stream<Provider> streamProvider = Stream.of(Provider.builder()
				.providerName("Dobatii")
				.providerAddress("6512 rue mazarin")
				.providerCity("Montréal")
				.providerZipCode("H4E 2X5")
				.providerProvince(null)
				.build());
		
		return Flux.fromStream(streamProvider);
	}
	
	public Flux<Provider> getProviders(Province province){
		Stream<Provider> streamProvider = Stream.of(Provider.builder()
				.providerName("Dobatii")
				.providerAddress("6512 rue mazarin")
				.providerCity("Montréal")
				.providerZipCode("H4E 2X5")
				.providerProvince(province)
				.build());
		
		return Flux.fromStream(streamProvider);
	}
}
