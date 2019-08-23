package com.example.oc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.oc.entity.Product;

public interface DbRepository extends MongoRepository<Product, String>{

	
}
