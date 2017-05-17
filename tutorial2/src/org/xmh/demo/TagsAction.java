package org.xmh.demo;

import com.opensymphony.xwork2.*;

public class TagsAction extends ActionSupport {
	private String username;
	private String password;
	public TagsAction(){
	};

	public String execute(){
		this.addFieldError("fielderror.test","wrong!");
		return SUCCESS;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setUsername(String username){
		this.username=username;
	}
}
