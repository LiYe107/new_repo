package org.springcloud.consul.client.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class App implements CommandLineRunner
{
	@Autowired 
	ConsulDiscoveryClient consulDiscoveryClient;
	String result;
	
	@RequestMapping("/message")
	public String service() {
		return result;
	}

	@Override
	public void run(String... args) throws Exception {
		List<ServiceInstance> list = consulDiscoveryClient.getInstances("consul-demo1");
		ServiceInstance instance = list.get(0);
		String uri = instance.getUri().toString();//获取服务所在的URI
		String serviceId = instance.getServiceId();
		System.out.println("获取服务信息如下：");
		System.out.println("服务URI：" + uri);
		System.out.println("服务ID：" + serviceId);
		this.result = new RestTemplate().getForObject(uri + "/message", String.class);
		System.out.println("调取服务返回结果：" + result);
		
	}
	
	public static void main( String[] args )
	{
		SpringApplication.run(App.class, args);
	}
}



