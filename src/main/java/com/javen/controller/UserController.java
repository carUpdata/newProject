package com.javen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javan.util.ObjtoLayJson;
import com.javen.controller.UpKeepController.dataCheck;
import com.javen.model.UpKeep;
import com.javen.model.User;
import com.javen.service.UserService;
import com.javen.service.UpKeepService;

@Controller  //返回指定页面  ajax 不能接受到页面的返回 ，所以说
@RequestMapping("/user") 
public class UserController {
	
	private static Logger log=LoggerFactory.getLogger(UpKeepController.class);
	
	@Autowired
	private UserService UserService;     
	private UpKeepService UpKeepService;     
	
	@ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String login(HttpServletRequest request) throws Exception {
		
    	String user_idnumberString = request.getParameter("user_idnumber");
    	String user_passwordString = request.getParameter("user_password");
    	
    	User user = new User();
    	user.setUser_idnumber(user_idnumberString); 
    	user.setUser_password(user_passwordString); 
    	
    	boolean x = UserService.login(user);
    	String jsonString = "";
    	if(x) {
    		jsonString = "{\"message\":\"登录成功！\"}";
    	}else {
    		jsonString = "{\"message\":\"登录失败！\"}";
    	}
    	return jsonString;
    }
	
	@ResponseBody
    @RequestMapping(value="/delete", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
	public String deleteByPrimaryKey(int id) {//这样传参直接接收
	    //public String deleteByPrimaryKey(HttpServletRequest request) {
	    	//String  idString = request.getParameter("id");
	    	//Integer idInteger = Integer.valueOf(idString);
	    	//UpKeepService.deleteByPrimaryKey(idInteger);
	    	System.out.println("删除的id："+id);//这样传参直接接收
	    	
	    	UserService.deleteByPrimaryKey(id);
	    	String data = "{\"data\":\"返回删除成功\"}"; 
	        return data; 
	    }
	    
	    @ResponseBody
	    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
	    //public String insert(int car_id,String upkeep_date,String upkeep_distance,String upkeep_account,String upkeep_cost,String upkeep_date,String upkeep_distance) {
	    public String insert(HttpServletRequest request) {
	    //插入数据库
	    	
	    	String  car_idString = request.getParameter("car_id");
	    	String upkeep_dateString = request.getParameter("upkeep_date");
	    	String upkeep_distanceString = request.getParameter("upkeep_distance");
	    	String upkeep_accountString = request.getParameter("upkeep_account");
	    	String upkeep_costString = request.getParameter("upkeep_cost");
	    	String upkeep_addressString = request.getParameter("upkeep_address");
	    	String user_idnumberString = request.getParameter("user_idnumber");
	    	
	    	UpKeep upkeep = new UpKeep();
	    	
	    	try {
	    		upkeep.setCar_id(dataCheck.check1(car_idString));
	    		
	    	}catch(Exception e){
	    		e.getMessage();
	    	}
	    	
	    	upkeep.setUpkeep_date(upkeep_dateString);
	    	upkeep.setUpkeep_distance(upkeep_distanceString);
	    	upkeep.setUpkeep_account(upkeep_accountString);
	    	upkeep.setUpkeep_cost(upkeep_costString);
	    	upkeep.setUpkeep_address(upkeep_addressString);
	    	upkeep.setUser_idnumber(user_idnumberString);
	    	
	    	UserService.insert(upkeep);
	    	//System.out.print("插入");
	    	
	    	//给前台返回的东西
	    	String data = "{\"data\":\"返回插入成功\"}"; 
	        return data; 
	    }
	    
	    @ResponseBody
	    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
	    public String update(HttpServletRequest request) throws Exception {
	    	//修改内容
	    	String idString = request.getParameter("id");
	    	String car_idString = request.getParameter("car_id");
	    	String upkeep_dateString = request.getParameter("upkeep_date");
	    	String upkeep_distanceString = request.getParameter("upkeep_distance");
	    	String upkeep_accountString = request.getParameter("upkeep_account");
	    	String upkeep_costString = request.getParameter("upkeep_cost");
	    	String upkeep_addressString = request.getParameter("upkeep_address");
	    	String user_idnumberString = request.getParameter("user_idnumber");
	    	
	    	UpKeep upkeep = new UpKeep();
	    	//校验，调用方法
	    	
	    	String data = "";
	    	try {
	    		upkeep.setId(dataCheck.check1(idString));
	    		upkeep.setCar_id(dataCheck.check2(car_idString));
	    		  
	    	}catch(Exception e){
	    		e.getMessage();
	    	}
	    	
	    	
	    	
	    	upkeep.setUpkeep_date(upkeep_dateString);
	        upkeep.setUpkeep_distance(upkeep_distanceString);
	        upkeep.setUpkeep_account(upkeep_accountString);
	        upkeep.setUpkeep_cost(upkeep_costString);
	        upkeep.setUpkeep_address(upkeep_addressString);
	        upkeep.setUser_idnumber(user_idnumberString);	
	    	
	    	UserService.updateByPrimaryKey(upkeep);
	    	System.out.println("修改前数据的id："+idString);
	    	System.out.println("修改后数据的地址："+upkeep_addressString);
	    	
	    	data = "{\"status\":\"0\",\"data\":\"修改成功！\"}";
	        return data; 
	    }
	    

		//返回字符串
	    @ResponseBody
	    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
	    public String selectAll(String user_idnumber) throws Exception{  	  
	    	//System.out.println("在前面"+user_idnumber);
	    	List<UpKeep> upkeeps = UserService.selectAll(user_idnumber);
	    	//System.out.println(user_idnumber);
	      	String[] colums = {"id","car_id","upkeep_date","upkeep_distance","upkeep_account","upkeep_cost","upkeep_address","user_idnumber"};
	    	String data = ObjtoLayJson.ListtoJson(upkeeps, colums);
//	    	System.out.println("查询一个用户所有的数据。");
//	    	System.out.println(data);
//	    	System.out.println("***");
//	    	System.out.println("在后面"+user_idnumber);
	    	//String data = "{\"data\":\"返回删除成功\"}"; 
	    	return data; 
	    }
	   
	    public static class dataCheck {	
	    	public static int check1(String x) throws Exception{
	    		try {
	    			 return Integer.parseInt(x);
	    		}catch(Exception e) {
	    			throw new Exception("id参数有问题");
	    		}
	    	}
	    	
	    	public static int check2(String x) throws Exception{
	    		try {
	    			return Integer.parseInt(x);
	    		}catch(Exception e) {
	    			throw new Exception("车牌号有问题");
	    		}
	    	}
	    }
}
