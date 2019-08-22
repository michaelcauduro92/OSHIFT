package com.example.os.client.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.os.client.feign.RemoteFeignClient;
import com.example.os.client.service.RemoteCallService;

@Service
public class RemoteCallBean implements RemoteCallService {
	
//	@Value("${mycustomprop}")
//	private String sysProp;
	@Autowired
	RemoteFeignClient feignClient;
	@Override
	public List<String> getData() {
		
		return feignClient.getData().getBody();
	}

}
