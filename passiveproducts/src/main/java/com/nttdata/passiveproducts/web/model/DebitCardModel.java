package com.nttdata.passiveproducts.web.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardModel {
	
	@JsonIgnore
	private String cardId;
	
	@NotBlank(message="cardNumbercannot be null or empty")
	private String cardNumber;
	
	@NotBlank(message="openingDate cannot be null or empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate openingDate;
	
	@NotBlank(message="expiryDate cannot be null or empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@NotBlank(message="status cannot be null or empty")
	private Boolean status;
	
	@NotBlank(message="channelOpening cannot be null or empty")
	private String channelOpening;
	
	@NotBlank(message="userRegisteringId cannot be null or empty")
	private String userRegisteringId;
	
	@NotBlank(message="customerId cannot be null or empty")
	private String customerId;
	
	//@NotBlank(message="accounts cannot be null or empty")
	//private AccountModel accounts [];
	
}
