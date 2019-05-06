package org.springcloud.eureka.client.provlucy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	//http://localhost:8013/visit?visitor=zhang3
	@RequestMapping("/visit")
	public String index(String visitor) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hi "+visitor+"<br>");
		sb.append("I am " + appName + "<br>");
		sb.append("I am on Port:" + port);
		return sb.toString();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
