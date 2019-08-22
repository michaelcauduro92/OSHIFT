package com.example.oc.controller;

import java.util.ArrayList;
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
}
