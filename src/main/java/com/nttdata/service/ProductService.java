package com.nttdata.service;

import com.nttdata.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface ProductService
{
    void createCustomer(Product e);
     
    Mono<Product> findByCustomerId(Integer id);
 
    Flux<Product> findAllCustomer();
 
    Mono<Product> updateCustomer(Product e);
 
    Mono<Void> deleteCustomer(Integer id);
}