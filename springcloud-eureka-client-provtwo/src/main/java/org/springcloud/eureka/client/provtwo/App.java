package org.springcloud.eureka.client.provtwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class App 
{
	@Value("${spring.application.name}")
	String appName;
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/")
	public String home() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hi, this is Eureka Client " + appName);
		sb.append("<br>");
		sb.append("Port：" + port);
		return sb.toString();
	}
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
