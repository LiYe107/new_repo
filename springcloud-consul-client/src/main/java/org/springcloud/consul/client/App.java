package org.springcloud.consul.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class App 
{
	@RequestMapping("/")
	public String info() {
		return "Hi, I am a consul Client.";
	}
	
	@RequestMapping("/message")
	public String service() {
		return "给你一个(づ￣ 3￣)づ";
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
