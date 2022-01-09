package com.nttdata.controller;

import com.nttdata.model.Product;
import com.nttdata.service.ProductServiceImpl;
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
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Product employee) {
    	logger.info("creating customer");
        productServiceImpl.createCustomer(employee);
    }

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Product> findAll() {
    	logger.info("find customers");
        return productServiceImpl.findAllCustomer();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Mono<Product>> findEmpById(@PathVariable("id") Integer id) {
        Mono<Product> employee = productServiceImpl.findByCustomerId(id);
        return new ResponseEntity<Mono<Product>>(employee, employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> update(@RequestBody Product employee) {
    	
        return productServiceImpl.updateCustomer(employee);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        productServiceImpl.deleteCustomer(id).subscribe();
    }

}
