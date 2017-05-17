package com.xy.registration.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.xy.registration.dto.UserInfo;
@Entity
public class User {		
	private int id;
	private String username;
	private String password;
	public User(){		
	};
	public User(UserInfo userInfo){
		this.username=userInfo.getUsername();
		this.password=userInfo.getPassword();
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
