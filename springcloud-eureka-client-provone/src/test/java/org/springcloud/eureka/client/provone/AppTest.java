package org.springcloud.eureka.client.provone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
	@Autowired
	EurekaClient eurekaClient;
	
	@Test
	public void test() {
		//使用spring自动装配EurekaClient，然后通过手动输入服务名称发现服务的一个方式
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("eureka-provone", false);
		System.err.println(instance.getHomePageUrl());
		
	}
}
