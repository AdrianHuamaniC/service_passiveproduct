package com.nttdata.passiveproducts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.passiveproducts.domain.DebitCard;

@Repository
public interface DebitCardRepository extends ReactiveMongoRepository<DebitCard, String>, CustomDebitCardRepository{

	

}
