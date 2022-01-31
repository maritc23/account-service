package com.nttdata.service;

import com.nttdata.bean.AddAccountResult;
import com.nttdata.model.Account;
import com.nttdata.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface AccountService
{
	 Mono<Account> createAccount(Account e);
     
    Mono<Account> findByAccountId(Integer id);
 
    Flux<Account> findAllAccount();
    
    Flux<Account> findByClientId(String clientId);
 
    //Mono<Account> updateCustomer(Account e);
 
   // Mono<Void> deleteCustomer(Integer id);
}