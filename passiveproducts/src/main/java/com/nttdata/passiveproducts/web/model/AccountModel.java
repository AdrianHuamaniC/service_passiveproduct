package com.nttdata.passiveproducts.web.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.passiveproducts.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {

	@JsonIgnore
	private String accountId;
	
	@NotBlank(message="accountType cannot be null or empty")
	private String accountType;
	
	@NotBlank(message="modalityAccount cannot be null or empty")
	private String modalityAccount;
	
	@NotBlank(message="accountNumber cannot be null or empty")
	private String accountNumber;
	
	@NotBlank(message="cci cannot be null or empty")
	private String cci;
	
	@NotBlank(message="availableBalance cannot be null or empty")
	private Double availableBalance;
	
	@NotBlank(message="balance cannot be null or empty")
	private Double balance;
	
	@NotBlank(message="userRegisteringId cannot be null or empty")
	private String userRegisteringId;
	
	@NotBlank(message="currency cannot be null or empty")
	private String currency;
	
	@NotBlank(message="maintenanceCommision cannot be null or empty")
	private Double maintenanceCommision;
	
	@NotBlank(message="movementQuantity cannot be null or empty")
	private Integer movementQuantity;
	
	@NotBlank(message="movementFrecuency cannot be null or empty")
	private Integer movementFrecuency;
	
	@NotBlank(message="customers cannot be null or empty")
	private Customer customers[];
	
	private Customer signatories[];
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate openingDate;
}
