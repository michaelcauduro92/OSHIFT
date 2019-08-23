package com.example.oc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oc.entity.Product;
import com.example.oc.repository.DbRepository;

@RestController
@RequestMapping("oc-backend")
public class DbController {

	@Autowired
	DbRepository repo;
	
	@GetMapping("/getData")
	public ResponseEntity<List<String>> getData(){
		initDb();
		
		List<String> productNameList=new ArrayList<String>(); 
		try {
			List<Product> productList=repo.findAll();
			
			for (Product product : productList) {
				productNameList.add(product.getName());
			}
			return ResponseEntity.ok(productNameList);
		}catch(RuntimeException exception) {
			return ResponseEntity.ok(Collections.singletonList("error"));
		}
	}
	
	private void initDb() {
		Product product1=new Product();
		product1.setId("idP1");
		product1.setName("product3");
		Product product2=new Product();
		product2.setId("idP2");
		product2.setName("product2");
		
		repo.saveAll(Arrays.asList(product1,product2));
	}
}
