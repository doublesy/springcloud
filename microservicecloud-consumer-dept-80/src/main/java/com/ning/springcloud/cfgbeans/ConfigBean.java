package com.ning.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//用于类上，表示这个类是一个配置类
@Configuration
public class ConfigBean{  // boot --> spring applicationContext.xml
    
	@Bean
    public RestTemplate getRestTemplate(){
         return new RestTemplate();
    }
}

// applicationContext.xml  == ConfigBean(@Configuration)
//<bean id="userService" class="com.ning.tmall.UserServiceImpl">