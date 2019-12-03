package com.dobatii.dockerization1.provider.data;

import lombok.Builder;
import lombok.Data;

/**
 * Provider Data
 * 
 * @author 9386-2142 Qc inc
 * @version 1.0
 * 2019-05-12
 * 
 */

@Data
@Builder
public class Provider {
private Long id;
	
//	@NotNull(message="Le nom de la compagnie est obligatoire!")
	private String providerName;
	
	// Company address
//	private Integer civilNumber;
//	private ETypePath typePath;
//	private String typePathName;
	
	private String providerAddress;
	
//	@NotNull(message="La ville dans laquelle siège la compagnie est obligatoire!")
	private String providerCity;
	
	private String providerZipCode;
	
//	@ManyToOne
	private Province providerProvince;
}
