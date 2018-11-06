package com.ning.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

//用于类上，表示这个类是一个配置类
@Configuration
public class ConfigBean{  // boot --> spring applicationContext.xml
    
	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具
    public RestTemplate getRestTemplate(){
         return new RestTemplate();
    }
	
	/**
	 * 修改原有负载均衡策略
	 *  达到目的的，用我们重新选择的随机算法替代默认的轮询
	 * @return
	 */
	@Bean
	public IRule myRule() {
//		return new RoundRobinRule(); //轮询（默认的）
//		return new RandomRule(); //随机
		return new RetryRule();
	}
}

// applicationContext.xml  == ConfigBean(@Configuration)
//<bean id="userService" class="com.ning.tmall.UserServiceImpl">