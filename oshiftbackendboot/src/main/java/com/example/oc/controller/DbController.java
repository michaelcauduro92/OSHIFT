package com.example.oc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oc.entity.Product;
import com.example.oc.repository.DbRepository;

@RestController
@RequestMapping("oc-backend")
public class DbController {

	@Autowired
	DbRepository repo;
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return ResponseEntity.ok("welcome");
	}
	@PostMapping("/insertData")
	public ResponseEntity<String> insertDefaultData(){
		try {			
			initDb();
		}catch(RuntimeException exception) {
			return ResponseEntity.ok("error");
		}
		return ResponseEntity.ok("operation done ");
	}
	
	@GetMapping("/getData")
	public ResponseEntity<List<String>> getData(){
		
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
		Random random=new Random();
		Product product1=new Product();
		product1.setId("idP"+random.nextInt());
		product1.setName("product");
		
		repo.save(product1);
	}
}
