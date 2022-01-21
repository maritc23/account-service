package com.nttdata.service;

import com.nttdata.model.Customer;

import reactor.core.publisher.Mono;

public interface ClientService {
	Mono<Customer> verifyClient(Integer id); 
	Customer verifyClient2(Integer id);
	Mono<Object> verifyClient3(Integer id); 
}
