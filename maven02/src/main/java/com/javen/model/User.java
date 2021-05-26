package com.javen.model;

public class User {
	private int id;
	private String user_idnumber;
	private String user_name;
	private String flag;
	private String user_password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_idnumber() {
		return user_idnumber;
	}
	public void setUser_idnumber(String user_idnumber) {
		this.user_idnumber = user_idnumber;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "UserDao [id=" + id + ", user_idnumber=" + user_idnumber + ", user_name=" + user_name + ", flag=" + flag
				+ ", user_password=" + user_password + "]";
	}
}
