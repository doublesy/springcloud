package com.ning.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 自定义的负载均衡随机算法
 * @author doublening
 *
 */
@Configuration
public class MySelfRule {
	
	@Bean
	public IRule myRule() {
//		return new RandomRule(); //默认为轮询，自定义为随机
//		return new RoundRobinRule(); //Ribbon默认是乱写，我自定义为随机
		
		return new RandomRule_ZY(); //我自定义每台5次
		
	}
}
