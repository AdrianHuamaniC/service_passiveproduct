package com.bootcamp.passiveProduct.web.model;


import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

//import com.bootcamp.passiveProduct.domain.Client;
//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalAccountModel {

	@JsonIgnore
	private String id;
	
	@NotBlank(message="accountType cannot be null or empty")
	private String accountType;
	
	//@NotBlank(message="accountNumber cannot be null or empty")
	//private String accountNumber;
	
	//@NotBlank(message="cci cannot be null or empty")
	//private String cci;
	
	//@NotBlank(message="availableBalance cannot be null or empty")
	//private Double availableBalance;
	
	//@NotBlank(message="balance cannot be null or empty")
	//private Double balance;
	
	//@NotBlank(message="userRegisteringId cannot be null or empty")
	//private String userRegisteringId;
	
	@NotBlank(message="currency cannot be null or empty")
	private String currency;
	
	//@NotBlank(message="maintenanceCommision cannot be null or empty")
	//private Double maintenanceCommision;
	
	//@NotBlank(message="movementQuantity cannot be null or empty")
	private Integer movementQuantity;
	
	//@NotBlank(message="movementQuantityMax cannot be null or empty")
	private Integer movementQuantityMax;
	
	//@NotBlank(message="movementFrecuency cannot be null or empty")
	private Integer movementFrecuency;
	
	//@NotBlank(message="customers cannot be null or empty")
	//private ClientModel client;
	
	@NotBlank(message="identityNumberClient cannot be null or empty")
    private String identityNumberClient; //numero de documento

	@NotBlank(message="identityTypeClient  cannot be null or empty")
    private String identityTypeClient; //codigo tipo de documento
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//private LocalDate openingDate;
}
