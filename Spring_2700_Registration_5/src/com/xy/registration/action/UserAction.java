package com.xy.registration.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.xy.registration.model.User;
import com.xy.registration.service.UserManager;
@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String password2;
	private UserManager um;
	public UserManager getUm() {
		return um;
	}
	@Resource(name="UserManager")
	public void setUm(UserManager um) {
		this.um = um;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	@Override
	public String execute() throws Exception{	
		User u=new User();
		u.setPassword(password);
		u.setUsername(username);
		boolean exist=um.exists(u);
		if (exist)
		{	
			System.out.println("fail");		
			return "fail";}
		else{
			um.add(u);
			System.out.println("success");
			return 	"success";
		}
	}
	public static void main(String[] args) throws Exception {
		UserAction ua=new UserAction();
		ua.setPassword("123");
		ua.setUsername("ddf");
		ua.execute();
	}
	
}
