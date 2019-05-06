package org.springcloud.eureka.client.customer.controller;

import org.springcloud.eureka.client.customer.service.RibbonCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonCustomerController {

	@Autowired
	RibbonCustomerService ribbonCustomerService;
	
	@RequestMapping("/customer")
	public String customer() {
		return ribbonCustomerService.doService();
	}
}
