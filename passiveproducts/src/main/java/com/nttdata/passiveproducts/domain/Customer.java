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
@EqualsAndHashCode(of = {"documentCode"})
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "customer")
public class Customer {
	
	@Id
	private String clientId;
	
	@NotNull
	private String documentType;
	
	@NotNull
	@Indexed(unique = true)
	private String documentCode;
	
	@NotNull
	private String name;
	
	private String lastName;
	
	//@NotNull
	private LocalDate birthDate;
	
	@NotNull
	private String nationality;
	
	@NotNull
	private String gender;
	
	@NotNull
	private Boolean resident;
	
	private String civilStatus;
	
	private String instruction;
	
	@NotNull
	private String customerType;
	
	@NotNull
	private String cellPhone;
	
	private String  emails;
	
	@NotNull
	private String location;
	
	@NotNull
	private String direction;
	
	@NotNull
	private Boolean employee;
	
	//@NotNull
	private LocalDate creationDate;
	
	//@NotNull
	private LocalDate changeDate;

}
