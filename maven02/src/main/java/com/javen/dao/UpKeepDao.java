package com.javen.dao;


import java.util.List;

import com.javen.model.UpKeep;


public interface UpKeepDao {
	
	public UpKeep selectByPrimaryKey(int id);
	
	public int deleteByPrimaryKey(int id);
	
	public int insert(UpKeep upkeep);
	
	public int updateByPrimaryKey(UpKeep upkeep);
	
	/*int count();*/
	
	public List<UpKeep> selectAll();
	
}
