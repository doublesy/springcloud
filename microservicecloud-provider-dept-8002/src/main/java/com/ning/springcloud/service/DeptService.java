package com.ning.springcloud.service;

import java.util.List;

import com.ning.springcloud.entities.Dept;

public interface DeptService {
	public boolean add(Dept dept);
	public Dept    get(Long id);
	public List<Dept> list();
}
