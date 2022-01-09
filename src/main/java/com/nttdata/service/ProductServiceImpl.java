package com.nttdata.service;

import com.nttdata.dao.ProductRepository;
import com.nttdata.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository customerRepo;

    public void createCustomer(Product employee) {
        customerRepo.save(employee).subscribe();
    }

    public Mono<Product> findByCustomerId(Integer id) {
        return customerRepo.findById(id);
    }

    public Flux<Product> findAllCustomer() {
        return customerRepo.findAll();
    }

    public Mono<Product> updateCustomer(Product employee) {
        return customerRepo.save(employee);
    }

    public Mono<Void> deleteCustomer(Integer id) {
        return customerRepo.deleteById(id);
    }

	
}