package com.xsh.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xsh.springboot.entity.User;

@Mapper//标注是一个Mapper映射器接口
public interface UserMapper {
	
	public List<User> findAll();
}
