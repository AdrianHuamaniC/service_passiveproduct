package com.nttdata.passiveproducts.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.passiveproducts.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"accountId"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "account")
public class Account {

	@Id
	private String accountId;
	
	@NotNull
	private String accountType;
	
	@NotNull
	private String modalityAccount;
	
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
	private Integer movementFrecuency;
	
	@NotNull
	private Customer customers[];
	
	private Customer signatories[];
	
	@NotNull
	private LocalDate openingDate;
}
