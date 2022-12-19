package com.bootcamp.passiveProduct.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "personalAccount")
public class PersonalAccount {
	
	

	@Id
	private String id;
	
	@NotNull
	private String accountType; //Ahorro-Corriente-plazo fijo
	
	@NotNull
	@Indexed(unique = true)
	private String accountNumber;
	
	@NotNull
	@Indexed(unique = true)
	private String cci;
	
	@NotNull
	private Double availableBalance;
	
	@NotNull
	private Double balance;
	
	@NotNull
	private String userRegisteringId;
	
	@NotNull
	private String currency;
	
	@NotNull
	private Double maintenanceCommision;
	
	@NotNull
	private Integer movementQuantity;
	
	@NotNull
	private Integer movementQuantityMax;
	
	@NotNull
	private Integer movementFrecuency;
	
	@NotNull
    private String identityNumberClient; //numero de documento

    @NotNull
    private String identityTypeClient; //codigo tipo de documento
	
	@NotNull
	private LocalDate openingDate;
	
	@NotNull
	private List<PersonalAccountTransaction> transactions= new ArrayList<PersonalAccountTransaction>();
	
	public void addTransaction(PersonalAccountTransaction personalAccountTransaction) {
		this.transactions.add(personalAccountTransaction);
	}
	
	
}
