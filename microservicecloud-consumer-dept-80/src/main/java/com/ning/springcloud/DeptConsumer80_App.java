package com.ning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ning.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//表示针对MICROSERVICECLOUD-DEPT这个微服务采用自定义MySelfRule的负载均衡算法规则
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration=MySelfRule.class)	
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
