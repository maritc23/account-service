package com.nttdata.configserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nttdata.model.Account;
import com.nttdata.service.AccountService;
import reactor.test.StepVerifier;
import reactor.core.publisher.Mono;

@SpringBootTest
class AccountServiceApplicationTests {

	@Autowired
	AccountService accountService;
	
	@Test
	void testAccountNotEmpty() {
		Mono<Account> account = accountService.findByAccountId(1);
	    StepVerifier.create(account).expectNextCount(1).verifyComplete();
	}

}
