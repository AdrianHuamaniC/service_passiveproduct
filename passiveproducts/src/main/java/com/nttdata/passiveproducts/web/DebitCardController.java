package com.nttdata.passiveproducts.web;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.passiveproducts.domain.Customer;
import com.nttdata.passiveproducts.domain.DebitCard;
import com.nttdata.passiveproducts.service.DebitCardService;
import com.nttdata.passiveproducts.web.mapper.CustomerMapper;
import com.nttdata.passiveproducts.web.mapper.DebitCardMapper;
import com.nttdata.passiveproducts.web.model.CustomerModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/debitCard")
public class DebitCardController {

	
	@Autowired
    private DebitCardService debitCardService;

	
	//@Autowired
    //private DebitCardMapper debitCardMapper;
	
	//@Autowired
    private CustomerMapper customerMapper;



	  /*@GetMapping("/client/{clientId}")
	    public Mono<ResponseEntity<CustomerModel>> getById(@PathVariable String clientId){
	    	log.info("getById executed {}", clientId);
	        Mono<Customer> response = debitCardService.getClientByIdentityNumber(clientId);
	        return response
	        	   .map(customer -> customerMapper.entityToModel(customer))
	        	   .map(ResponseEntity::ok)
	               .defaultIfEmpty(ResponseEntity.notFound().build());
	    }*/
    
    @GetMapping("/client/{clientId}")
    public Mono<Customer> getById(@PathVariable String clientId){
    	log.info("getById executed {}", clientId);
    	if (debitCardService.existClient(clientId)) {
    		log.info("Cliente encontrado {}", clientId);
    		return debitCardService.getClientByIdentityNumber(clientId);
		}else {
			log.info("Cliente no existe {}", clientId);
			return Mono.empty();
		}
        //return debitCardService.getClientByIdentityNumber(clientId);
    }
    
    @GetMapping("/{clientId}")
    public Flux<DebitCard> listDebitCardByCustomer(@PathVariable String clientId){
    	log.info("listDebitCardByCustomer {}", clientId);
        return debitCardService.getDebitCardByCustomerId(clientId);
    }

    @PostMapping
    public Mono<DebitCard> debitCardOpening(@RequestBody DebitCard debitCard){
    	return debitCardService.create(debitCard);
    }
    
}
