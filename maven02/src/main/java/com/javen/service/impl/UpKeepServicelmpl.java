package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.dao.UpKeepDao;
import com.javen.model.UpKeep;
import com.javen.service.UpKeepService;

@Service
public class UpKeepServicelmpl implements UpKeepService{

	//@Resource
	@Autowired
	private UpKeepDao UpKeepDao;
	
	
	
	public UpKeep selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.UpKeepDao.selectByPrimaryKey(id);
	}

	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.UpKeepDao.deleteByPrimaryKey(id);
	}

	public int insert(UpKeep upkeep) {
		// TODO Auto-generated method stub
		return this.UpKeepDao.insert(upkeep);
	}

	//public int updateByPrimaryKey(UpKeep upkeep) {
	public int updateByPrimaryKey(UpKeep upkeep) { 
		// TODO Auto-generated method stub
		return this.UpKeepDao.updateByPrimaryKey(upkeep);
	}

	/*public int count() {
		// TODO Auto-generated method stub
		return this.UpKeepDao.count();
	}*/
	
	public List<UpKeep> selectAll() {
		// TODO Auto-generated method stub
		return this.UpKeepDao.selectAll();
	}
}
