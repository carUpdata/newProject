package com.javen.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.javan.util.ObjtoLayJson;
import com.javen.model.UpKeep;
import com.javen.service.UpKeepService;

@Controller  //返回指定页面  ajax 不能接受到页面的返回 ，所以说
@RequestMapping("/upkeep") 
public class UpKeepController {
	
	private static Logger log=LoggerFactory.getLogger(UpKeepController.class);
	
	//@Resource  
	@Autowired
	private UpKeepService UpKeepService;     
    
    // /user/test?id=1
    @RequestMapping(value="/test", method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        return "back"; 
    }
    
    //返回字符串
    @ResponseBody
    @RequestMapping(value="/selectById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectById(HttpServletRequest request) throws Exception{  
    	String  idString = request.getParameter("id");
    	Integer idInteger = Integer.valueOf(idString);
    	UpKeep upkeep = UpKeepService.selectByPrimaryKey(idInteger);
    	//System.out.println(upkeep.toString());
    	String[] colums = {"id","car_id","upkeep_date","upkeep_distance","upkeep_account","upkeep_cost","upkeep_address","user_idnumber"};
    	String data = ObjtoLayJson.toJson(upkeep, colums);
    	System.out.println(data);
        return data;     
    }
    
    @ResponseBody
    @RequestMapping(value="/deleteByPrimaryKey", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String deleteByPrimaryKey(int id) {//这样传参直接接收
    //public String deleteByPrimaryKey(HttpServletRequest request) {
    	//System.out.println(id);//这样传参直接接收
    	UpKeepService.deleteByPrimaryKey(id);
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
    	
    	UpKeepService.insert(upkeep);
    	
    	
    	//给前台返回的东西
    	String data = "{\"data\":\"返回插入成功\"}"; 
        return data; 
    }
    
    @ResponseBody
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String update(HttpServletRequest request) throws Exception {
    	//修改内容
    	//String idString = request.getParameter("id");
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
    		//upkeep.setId(dataCheck.check1(idString));
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
    	
    	UpKeepService.updateByPrimaryKey(upkeep);
        return data; 
    }
    

	//返回字符串
    @ResponseBody
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  
    public String selectAll(HttpServletRequest request) throws Exception{  	
    	request.setCharacterEncoding("utf-8");  
    	String pageString = request.getParameter("page");
    	String limitString = request.getParameter("limit");
    	//System.out.println("当前页面："+pageString + "；每页多少条数据："+limitString);
    	    	
    	List<UpKeep> upkeeps = UpKeepService.selectAll();
   
      	String[] colums = {"id","car_id","upkeep_date","upkeep_distance","upkeep_account","upkeep_cost","upkeep_address","user_idnumber"};
    	String data = ObjtoLayJson.ListtoJson(upkeeps, colums);
    	System.out.println(data);
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









