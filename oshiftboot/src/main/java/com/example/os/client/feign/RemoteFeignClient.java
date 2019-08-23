package com.example.os.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="osbackend",url="${microservices.osbackend.url}")
public interface RemoteFeignClient {

	@RequestMapping("oc-backend/getData")
	public ResponseEntity<List<String>> getData();
}
