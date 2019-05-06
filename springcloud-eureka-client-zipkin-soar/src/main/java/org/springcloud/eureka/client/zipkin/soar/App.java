package org.springcloud.eureka.client.zipkin.soar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class App 
{
	//soar需要调用ironman的服务
	@Autowired
	public RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTmplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("/")
	public String index() {
		return "Hi, I am Soar.";
	}
	
	@RequestMapping("/info")
	public String info() {
		//调用ironman所在端口的服务
		return restTemplate.getForObject("http://localhost:8071/info", String.class);
	}
	
	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
