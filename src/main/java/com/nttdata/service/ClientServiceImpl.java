package com.nttdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.controller.AccountController;
import com.nttdata.exception.NttException;
import com.nttdata.model.Account;
import com.nttdata.model.Customer;

import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	private final WebClient webclient;

	
	public ClientServiceImpl() {
		//this.webclient = webclient;
		webclient = WebClient.create("http://localhost:8081/");
		//this.webClient = webClientBuilder.baseUrl("http://localhost:8081/").build();
	}
	
	public Mono<Customer> verifyClient(Integer id) {
		return  webclient.get()
                .uri("/customers/1")
                //.header(HttpHeaders.AUTHORIZATION, requestTokenHeader)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class);
		
    }
	
	public Customer verifyClient2(Integer id) {
		return  webclient.get()
                .uri("/customers/1")
                //.header(HttpHeaders.AUTHORIZATION, requestTokenHeader)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class).block();	
    }
	
	public Mono<Object> verifyClient3(Integer id) {
		return  webclient.get()
                .uri("/customers/"+id)
                //.header(HttpHeaders.AUTHORIZATION, requestTokenHeader)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .onErrorMap(e -> new NttException(String.format("could not get customer with id %s", id))) // Handle errors
                .flatMap(response -> {
                	if (response.statusCode() != null && (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError())) {
                		return Mono.error(new NttException(String.format("could not get customer with id %s", id)));
                	}
                	
                	logger.info("probando log");
                	return response.bodyToMono(Customer.class);
                });
                
               
                
    }

	
}	
