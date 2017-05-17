package com.xy.www;


public class JavaTest {
	private User user;
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user=user;
	}
	public String execute(){
		if (user.username.equals("123")) {
			return "loginSuccess";
		} else {
			return "loginFailure";
		}

	}
	
}
