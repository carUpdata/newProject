package com.javen.service;

import java.util.List;

import com.javen.model.UpKeep;



public interface UpKeepService {
	//所有你想要实现的方法一定要在这个地方定义
	
	 public UpKeep selectByPrimaryKey(int id);
	 
	 public int deleteByPrimaryKey(int id);
	 
	 public int insert(UpKeep upkeep);
	 
	 public int updateByPrimaryKey(UpKeep upkeep);
	 
	 /*public int count();*/
	 
	 public List<UpKeep> selectAll();
	 
}
