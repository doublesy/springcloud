package com.ning.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.springcloud.dao.DeptDao;
import com.ning.springcloud.entities.Dept;
import com.ning.springcloud.service.DeptService;

/**
 * dao层的话用find、service和controller层的话尽量用get、list这些符合restful风格的方法
 * @author doublening
 *
 */
@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao dao ;

	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return dao.findAll();
	}

}
