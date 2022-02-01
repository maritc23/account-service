package com.nttdata.service;

import com.nttdata.bean.AddAccount;
import com.nttdata.bean.AddAccountResult;
import com.nttdata.controller.AccountController;
import com.nttdata.dao.AccountRepository;
import com.nttdata.model.Account;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    ClientService clienteService;

    public Mono<Account> createAccount(Account account) {
    
    	account.setCreateAt(new Date());
    	return accountRepo.save(account);
    }

    public Mono<Account> findByAccountId(Integer id) {
        return accountRepo.findById(id);
    }

    public Flux<Account> findAllAccount() {
        return accountRepo.findAll();
    }

	@Override
	public Flux<Account> findByClientId(String clientId) {
		return accountRepo.findByClientId(clientId);
	}

	
}