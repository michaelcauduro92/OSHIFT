package com.example.oc.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oc.entity.Product;

public interface DbRepository extends JpaRepository<Product, String>{

	
}
