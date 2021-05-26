package com.javen.service;

import java.util.List;

import com.javen.model.User;
import com.javen.model.UpKeep;

public interface UserService {
	
	 public boolean login(User user) ;
	 
	 public int deleteByPrimaryKey(int id);
	 
	 public int insert(UpKeep upkeep);
	 
	 public int updateByPrimaryKey(UpKeep upkeep);
	 
	 /*public int count();*/
	 
	 public List<UpKeep> selectAll(String user_idnumber);
}
