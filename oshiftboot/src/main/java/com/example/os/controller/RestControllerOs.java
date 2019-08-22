package com.example.os.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.os.client.service.RemoteCallService;

@Controller
public class RestControllerOs {
	
	@Autowired
	private RemoteCallService remoteService;
	

	@GetMapping("/welcome")
	public ResponseEntity<String> Welcome() {
		return ResponseEntity.ok("index");
	}

	
	@GetMapping("/showList")
	public String showList(Model model){
		List<String> data=remoteService.getData();
		model.addAttribute("data",data);
		return"welcome";
	}
	
}
