package com.bjsxt.model;

public class User {
	private String username;
	private String password;
	public User(){
		System.out.println("User created");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
