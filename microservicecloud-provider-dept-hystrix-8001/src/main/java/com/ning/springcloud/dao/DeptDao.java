package com.ning.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ning.springcloud.entities.Dept;

@Mapper //表示这是一个MyBatis的mapper类（接口）
public interface DeptDao {
	
	public boolean addDept(Dept dept);
	 
	public Dept findById(Long id);
 
	public List<Dept> findAll();
}
