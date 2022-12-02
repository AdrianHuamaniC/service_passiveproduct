package com.nttdata.passiveproducts.repository;

import com.nttdata.passiveproducts.domain.DebitCard;

import reactor.core.publisher.Flux;

public interface CustomDebitCardRepository {

	Flux<DebitCard> findByCustomerId(String customerId);
}
