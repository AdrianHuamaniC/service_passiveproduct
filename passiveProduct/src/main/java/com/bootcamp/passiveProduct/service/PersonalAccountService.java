package com.bootcamp.passiveProduct.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.bootcamp.passiveProduct.domain.Client;
import com.bootcamp.passiveProduct.domain.PersonalAccount;
import com.bootcamp.passiveProduct.domain.PersonalAccountTransaction;
import com.bootcamp.passiveProduct.repository.PersonalAccountRepository;
import com.bootcamp.passiveProduct.web.mapper.PersonalAccountMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PersonalAccountService {

	@Autowired
	private PersonalAccountRepository personalAccountRepository;
	@Autowired
	private PersonalAccountMapper personalAccountMapper;
	
	private Long temporalAccountNumber=19211303551027L;
	
	private final WebClient webClient= WebClient.builder().baseUrl("http://localhost:8081/v1/client")
			.defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	
	public Mono<Client> getClientByIdentityNumber(String identityNumber){
		return this.webClient.get().uri("/findByIdentityNumber/{identityNumber}", identityNumber)
				.retrieve().bodyToMono(Client.class);
	}
	

	
	public Flux<PersonalAccount> findAll(){
		log.debug("FindAll executed");
		return personalAccountRepository.findAll();
	}
	
	public Mono<PersonalAccount> findById(String id){
		log.debug("findById executed {}", id);
		return personalAccountRepository.findById(id);
	}
	
	// public Flux<Account> findByCreditCardId- findByClient
	
	public Mono<PersonalAccount> createPersonalAccount(PersonalAccount personalAccount){
		log.debug("Created executed {}", personalAccount);
		return getClientByIdentityNumber(personalAccount.getIdentityNumberClient())
				.flatMap(client->{
					return personalAccountRepository.save(initializePersonalAccount(personalAccount));
				})
				.switchIfEmpty(Mono.error(new Exception("No existe cliente")));
	}
	
	public Mono<PersonalAccount> update(String id, PersonalAccount personalAccount){
		log.debug("update executed {}:{}",id, personalAccount);
		return personalAccountRepository.findById(id)
				.flatMap(x -> {
					personalAccountMapper.update(x, personalAccount);
					return personalAccountRepository.save(x);
				});
	}
	
	public Mono<PersonalAccount> delete(String id){
		log.debug("delete executed {}", id);
		return personalAccountRepository.findById(id)
				.flatMap(personalAccount -> personalAccountRepository.delete(personalAccount)
				.then(Mono.just(personalAccount)));
	}
	
	private String generateRandomAccountNumber() {
		return Long.toString(temporalAccountNumber+=1);
	}
	
	private String generateRandomCCI(String accountNumber) {
		return "002"+accountNumber+"02";
	}
	
	private Double maintenanceCommisionByAccountType(String accountType) {
		switch (accountType) {
		case "Corriente":
				return 0.0;
		case "Ahorro":
				return 0.025;
		case "PlazoFijo":
				return 0.0;
		default:
				return 0.0;
		}
	}
	
	private PersonalAccount initializePersonalAccount(PersonalAccount personalAccount) {
		personalAccount.setAccountNumber(generateRandomAccountNumber());
		personalAccount.setCci(generateRandomCCI(personalAccount.getAccountNumber()));
		personalAccount.setAvailableBalance(0.0);
		personalAccount.setBalance(0.0);
		personalAccount.setUserRegisteringId(System.getProperty("user.name"));
		personalAccount.setOpeningDate(LocalDate.now());
		personalAccount.setMovementQuantity(0);
		personalAccount.setMaintenanceCommision(maintenanceCommisionByAccountType(personalAccount.getAccountType()));
		return personalAccount;
	}
	
	
	
	
	public Mono<PersonalAccount> retirement(PersonalAccountTransaction personalAccountTransaction){
		log.debug("Retirement executed:  ",personalAccountTransaction);
		
			return findByAccountNumber(personalAccountTransaction.getSourceAccount())
					.flatMap(account->{
						
						/*if (validateRetirement(personalAccountTransaction)) {
							account.setBalance(account.getBalance()-getAmountTotal(account.getAccountType(),personalAccountTransaction.getAmount()));
							account.setAvailableBalance(account.getBalance()-getAmountTotal(account.getAccountType(),personalAccountTransaction.getAmount()));
							account.addTransaction(personalAccountTransaction);
							return personalAccountRepository.save(account);
						}else {
							return Mono.error(new Exception("No dispone del saldo solicitado"));
						}*/
						account.setBalance(account.getBalance()-getAmountTotal(account.getAccountType(),personalAccountTransaction.getAmount()));
						account.setAvailableBalance(account.getBalance()-getAmountTotal(account.getAccountType(),personalAccountTransaction.getAmount()));
						account.addTransaction(personalAccountTransaction);
						return personalAccountRepository.save(account);
					})
					.switchIfEmpty(Mono.error(new Exception("Transaccion no valida")));
	}
	
	//validar el tipo de transaccion
	
	private Boolean validateRetirement(PersonalAccountTransaction personalAccountTransaction) {
		PersonalAccount personalAccount=(PersonalAccount)(findByAccountNumber(personalAccountTransaction.getSourceAccount()).subscribe());
		return (personalAccount.getCurrency()==personalAccountTransaction.getCurrrency() & 
				personalAccount.getAvailableBalance()>=getAmountTotal(personalAccount.getAccountType(),personalAccountTransaction.getAmount()));
	}
	
	private Double getAmountTotal(String accountType,Double amount) {
		//PersonalAccount personalAccount=(PersonalAccount) personalAccountService.findByAccountNumber(sourceAccount).subscribe();
		//falta definir el monto de comision por tipo de operacion o cuenta
		return (1.025*amount);
	}
	
	public Flux<PersonalAccountTransaction> findAllTransactionByAccountNumber(String accountNumber){
		log.debug("FindAll executed");
		return findAll();
	}
	
	public Mono<PersonalAccount> findByAccountNumber(String accountNumber){
		return personalAccountRepository.findByAccountNumber(accountNumber);
	}
	
}
