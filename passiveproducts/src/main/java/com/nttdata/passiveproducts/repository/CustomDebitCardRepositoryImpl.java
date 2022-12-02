package com.nttdata.passiveproducts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.nttdata.passiveproducts.domain.DebitCard;

import reactor.core.publisher.Flux;

public class CustomDebitCardRepositoryImpl implements CustomDebitCardRepository{

	private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public CustomDebitCardRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	@Override
	public Flux<DebitCard> findByCustomerId(String customerId) {
		 
	    Query query = new Query(Criteria.where("customerId").is(customerId)); 

	    //Update update = new Update().set("password", "");

	    // step 3
	    //return mongoTemplate.findAndModify(query, update, User.class);
	    return mongoTemplate.find(query, DebitCard.class);
	}

}
