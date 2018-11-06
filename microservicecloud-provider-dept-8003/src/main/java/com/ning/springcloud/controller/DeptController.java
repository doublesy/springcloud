package com.ning.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ning.springcloud.entities.Dept;
import com.ning.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client; //增加服务发现接口

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
	
//	@Autowired
//	private DiscoveryClient client; //增加服务被发现接口
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		//获取eureka里面的微服务 访问：http://localhost:8001/dept/discovery
		List<String> list = client.getServices();
		System.out.println("-----------" + list); //-----------[microservicecloud-dept]
		
		//获得以上信息以后在将以上信息复制下来，然后可以查看其端口、ip等信息
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" +
					element.getPort() + "\t" + element.getUri());
		}
		return this.client;
	}
	
}
