package com.nttdata.passiveproducts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.passiveproducts.domain.Account;
import com.nttdata.passiveproducts.domain.DebitCard;

import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String>{

	
}
