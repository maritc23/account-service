package com.nttdata.controller;

import com.nttdata.bean.AddAccount;
import com.nttdata.bean.AddAccountResult;
import com.nttdata.model.Account;
import com.nttdata.model.Customer;
import com.nttdata.service.AccountService;
import com.nttdata.service.AccountServiceImpl;
import com.nttdata.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClientService clientService;
    
    @PostMapping("/test")
   //* @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Mono<Customer>> test() {
    	logger.info("creating customer22");
    	Mono<Customer> c = clientService.verifyClient(1);
    	//c.doOnNext(customer ->  logger.info(customer.getDocumentNumber()));
    
    	return new ResponseEntity<Mono<Customer>>(c, c != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        //accountServiceImpl.createAccount(account);
    }


   /* quiero invokar a clientService.verifyClient(1)
    y validar si el resultado existo o no +
    para hacer mi invocacion a save account*/
    
    /*
    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> test2() {
    	logger.info("creating customer");
    	Customer c = clientService.verifyClient2(1);
    	
    	return new ResponseEntity<Customer>(c, c != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        //accountServiceImpl.createAccount(account);
    }/*
    
    /*
    @GetMapping(value = "/test3", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> test3() {
    	logger.info("creating customer33");
    	return clientService.verifyClient(1)
    	.flatMap(x->{
    		if(x!=null) {
    			logger.info(x.getDocumentNumber());
    			return Mono.just(x);
    		}
    		return Mono.empty();
    	}).flatMap(x => {
    		x = ok 
    				asdjasdaklsdjk
    	})
    
    	
    	//return new ResponseEntity<Mono<Object>>(resp, resp != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    	
        //accountServiceImpl.createAccount(account);
    }*/
    
    
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account) {
    	logger.info("creating customer");
    	accountService.createAccount(account);
    }

    @GetMapping(value = "/accounts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Account> findAll() {
    	logger.info("find accounts");
        return accountService.findAllAccount();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Mono<Account>> findEmpById(@PathVariable("id") Integer id) {
        Mono<Account> employee = accountService.findByAccountId(id);
        return new ResponseEntity<Mono<Account>>(employee, employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> addAccount(@RequestBody AddAccount request) {
    	logger.info("add account");
    	Account a= new Account();
    	a.setProductId(request.getProductId());
    	a.setClientId(request.getClientId());
    	a.setId(request.getId());
    	a.setAccountNumber(request.getAccountNumber());
		return accountService.createAccount(a)
    	.flatMap(x->{
    		if(x!=null) {
    			logger.info("cuenta creada "+x.getAccountNumber());
    			AddAccountResult res = new AddAccountResult();
    			res.setAccountId(x.getId()+"");
    			res.setAccountNumber(x.getAccountNumber());
    			res.setCreateAt(x.getCreateAt());
    			return Mono.just(res);
    		}
    		return Mono.empty();
    	});
    	
    	    	
    	//Mono<Customer> c = accountService.createAccount(a);
    	
    	//c.doOnNext(customer ->  logger.info(customer.getDocumentNumber()));
    
    	//return new ResponseEntity<Mono<Customer>>(c, c != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        //accountServiceImpl.createAccount(account);
    }

}
