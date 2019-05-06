package org.springcloud.eureka.client.feign.service;

import org.springframework.stereotype.Service;

//实现服务接口，实现断路器工作后的回调方法
@Service
public class FeignClientServiceImpl implements FeignClientService {

	@Override
	public String doService(String visitor) {
		return "Sorry, Feign Access Server Fail.";
	}

}
