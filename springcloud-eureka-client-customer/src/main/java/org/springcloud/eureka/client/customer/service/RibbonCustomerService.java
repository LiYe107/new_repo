package org.springcloud.eureka.client.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonCustomerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallbackError")
	public String doService() {
		//借助于RestTemplate通过服务名称在注册中心获取相应的服务
		return restTemplate.getForObject("http://EUREKA-PROVONE/", String.class);
	}
	
	public String fallbackError() {
		return "Sorry, access Server Fail.";
	}
}
