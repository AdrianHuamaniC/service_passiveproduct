package com.nttdata.passiveproducts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.passiveproducts.domain.Customer;
import com.nttdata.passiveproducts.domain.DebitCard;
import com.nttdata.passiveproducts.repository.DebitCardRepository;
import com.nttdata.passiveproducts.web.mapper.DebitCardMapper;
import com.nttdata.passiveproducts.web.model.CustomerModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DebitCardService {

	@Autowired
	private DebitCardRepository debitCardRepository;

	//@Autowired
	//private DebitCardMapper debitCardMapper;

	private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:9040/v1/customer")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

	public Mono<Customer> getClientByIdentityNumber(String clientId) {
        return this.webClient.get().uri("/{id}", clientId)
                .retrieve().bodyToMono(Customer.class);
    }
	
	public Boolean existClient(String clientId) {
		Mono<Customer> customer=this.webClient.get().uri("/{id}", clientId)
                .retrieve().bodyToMono(Customer.class);
		if(customer==null) {
			log.info("Cliente no existe {}", clientId);
			return false;
		}else {
			log.info("Cliente encontrado {}", clientId);
			return true;
		}
	}
	
	public Flux<DebitCard> getDebitCardByCustomerId(String customerId){
		//falta validar que el cliente exista
		return debitCardRepository.findByCustomerId(customerId);
	}

	public Mono<DebitCard> create(DebitCard debitCard){
		//Falta validar que el cliente exista
		log.debug("create Debitcard Executed", debitCard);
		return debitCardRepository.save(debitCard);
	}
	
	
	
	

}
