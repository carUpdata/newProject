package com.javen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.dao.UserDao;
import com.javen.dao.UpKeepDao;
import com.javen.model.UpKeep;
import com.javen.model.User;
import com.javen.service.UserService;

@Service
public class UserServicelmpl implements UserService{
	@Autowired
	private UserDao userDao;
	private UpKeepDao upkeepDao;
	
	public boolean login(User user) {
		
		List<User> users = userDao.login(user);
		
		if(users.size() == 1) {
			return true;
		}
		
		return false;
	}
	
	/*public UpKeep selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.UpKeepDao.selectByPrimaryKey(id);
	}*/

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(id);
	}

	public int insert(UpKeep upkeep) {
		// TODO Auto-generated method stub
		return this.userDao.insert(upkeep);
	}

	//public int updateByPrimaryKey(UpKeep upkeep) {
	public int updateByPrimaryKey(UpKeep upkeep) { 
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKey(upkeep);
	}

	/*public int count() {
		// TODO Auto-generated method stub
		return this.UpKeepDao.count();
	}*/
	
	public List<UpKeep> selectAll(String user_idnumber) {
		// TODO Auto-generated method stub
		return this.userDao.selectAll(user_idnumber);
	}
}
