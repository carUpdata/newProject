package com.javen.model;

import java.text.SimpleDateFormat;

public class UpKeep {
	
	private Integer id;
	private Integer car_id;
	private String upkeep_date;
	private String upkeep_distance;
	private String upkeep_account;
	private String upkeep_cost;
	private String upkeep_address;
	private String user_idnumber;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {	
		this.id = id;
	}
	public Integer getCar_id() {
		return car_id;
	}
	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}
	public String getUpkeep_date() {
		return upkeep_date;
	}
	public void setUpkeep_date(String upkeep_date) {
		this.upkeep_date = upkeep_date;
	}
	public String getUpkeep_distance() {
		return upkeep_distance;
	}
	public void setUpkeep_distance(String upkeep_distance) {
		this.upkeep_distance = upkeep_distance;
	}
	public String getUpkeep_account() {
		return upkeep_account;
	}
	public void setUpkeep_account(String upkeep_account) {
		this.upkeep_account = upkeep_account;
	}
	public String getUpkeep_cost() {
		return upkeep_cost;
	}
	public void setUpkeep_cost(String upkeep_cost) {
		this.upkeep_cost = upkeep_cost;
	}
	public String getUpkeep_address() {
		return upkeep_address;
	}
	public void setUpkeep_address(String upkeep_address) {
		this.upkeep_address = upkeep_address;
	}
	public String getUser_idnumber() {
		return user_idnumber;
	}
	public void setUser_idnumber(String user_idnumber) {
		this.user_idnumber = user_idnumber;
	}
	@Override
	public String toString() {
		return "UpKeep [id=" + id + ", car_id=" + car_id + ", upkeep_date=" + upkeep_date + ", upkeep_distance="
				+ upkeep_distance + ", upkeep_account=" + upkeep_account + ", upkeep_cost=" + upkeep_cost
				+ ", upkeep_address=" + upkeep_address + ", user_idnumber=" + user_idnumber + "]";
	}
}
