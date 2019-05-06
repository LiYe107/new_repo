package org.springcloud.eureka.client.zipkin.ironman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class App 
{
	@RequestMapping("/")
	public String index() {
		return "Hi, I am IronMan.";
	}
	
	@RequestMapping("/info")
	public String info() {
		return "IronMan: 送你个锤子.";
	}
	//以Bean的形式注册链路追踪信息采集器
	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
