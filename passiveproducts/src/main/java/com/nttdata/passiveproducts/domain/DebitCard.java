package com.nttdata.passiveproducts.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@EqualsAndHashCode(of = {"cardId"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "debitcard")
public class DebitCard {
	
	@Id
	private String cardId;
	
	@NotNull
	@Indexed(unique = true)
	private String cardNumber;
	
	@NotNull
	private LocalDate openingDate;
	
	@NotNull
	private LocalDate expiryDate;
	
	@NotNull
	private Boolean status;
	
	@NotNull
	private String channelOpening;
	
	@NotNull
	private String userRegisteringId;
	
	@NotNull
	private String customerId;
	
	//@NotNull
	//private Account accounts [];
	
}
