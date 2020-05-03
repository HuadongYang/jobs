package com.practice.prac6;

public class User {

	private String userName;
	private String password;
	
	public User() {}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean check() {
		if (userName == null || password == null) {
			return false;
		}
		if (userName.equals("admin") && password.equals("admin")) {
			return true;
		}
		return false;
	}
}
