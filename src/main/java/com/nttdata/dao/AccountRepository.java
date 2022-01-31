package com.nttdata.dao;

import com.nttdata.model.Account;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, Integer> {
	Flux<Account> findByClientId(String clientId);
}