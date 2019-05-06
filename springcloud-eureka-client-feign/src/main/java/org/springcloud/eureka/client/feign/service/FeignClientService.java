package org.springcloud.eureka.client.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//以FeignClient方式访问服务的接口
//指定要访问的服务名称
//当访问服务失败时，指定回调的方法实现类
@FeignClient(value="EUREKA-PROVLUCY", fallback=FeignClientServiceImpl.class)
public interface FeignClientService {
	
	@RequestMapping("/visit")
	public String doService(@RequestParam("visitor")String visitor);
}
