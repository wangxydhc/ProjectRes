package com.xy.www;


public class JavaTest {
	
	private String username;
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String execute(){
		if (username.equals("123")) {
			return "loginSuccess";
		} else {
			return "loginFailure";
		}

	}
	
}
