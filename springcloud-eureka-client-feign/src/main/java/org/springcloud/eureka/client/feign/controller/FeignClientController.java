package org.springcloud.eureka.client.feign.controller;

import org.springcloud.eureka.client.feign.service.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

	@Autowired
	FeignClientService feignClientService;
	
	//对外定义一个访问点
	@RequestMapping("/feign")
	public String feign(String visitor) throws Exception {
		return feignClientService.doService(visitor);
	}
}
