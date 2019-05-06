package org.springcloud.eureka.client.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope//自动更新配置
public class App 
{
	@Value("${info}")
	String info;
	
	@RequestMapping("/demo")
	public String getInfo() {
		return "From GitHub: " + info;
	}
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
