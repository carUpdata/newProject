package com.javen.dao;

import java.util.List;

import com.javen.model.UpKeep;
import com.javen.model.User;

public interface UserDao {
	
	public List<User> login(User user) ;
	
	public int deleteByPrimaryKey(int id);
	 
	 public int insert(UpKeep upkeep);
	 
	 public int updateByPrimaryKey(UpKeep upkeep);
	 
	 /*public int count();*/
	 
	 public List<UpKeep> selectAll(String user_idnumber);
}
