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
public class CustomerModel {



	@JsonIgnore
	private String clientId;
	
	@NotBlank(message="Document Type cannot be null or empty")
	private String documentType;
	
	@NotBlank(message="Document Code cannot be null or empty")
	private String documentCode;
	
	@NotBlank(message="Name cannot be null or empty")
	private String name;
	
	private String lastName;
	
	//@NotBlank(message="Birth Date cannot be null or empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	@NotBlank(message="Nationality cannot be null or empty")
	private String nationality;
	
	@NotBlank(message="Gender cannot be null or empty")
	private String gender;
	
	//@NotBlank(message="Resident cannot be null or empty")
	private Boolean resident;
	
	private String civilStatus;
	
	private String instruction;
	
	@NotBlank(message="Customer Type cannot be null or empty")
	private String customerType;
	
	@NotBlank(message="Cell Phone number cannot be null or empty")
	private String cellPhone;
	
	private String  emails;
	
	@NotBlank(message="Location cannot be null or empty")
	private String location;
	
	@NotBlank(message="Direction cannot be null or empty")
	private String direction;
	
	//@NotBlank(message="Employee cannot be null or empty")
	private Boolean employee;
	
	//@NotBlank(message="Creation date cannot be null or empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate creationDate;
	
	//@NotBlank(message="Creation date cannot be null or empty")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate changeDate;
   
}
