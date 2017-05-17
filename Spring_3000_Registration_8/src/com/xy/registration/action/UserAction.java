package com.xy.registration.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xy.registration.dto.UserInfo;
import com.xy.registration.model.User;
import com.xy.registration.service.UserManager;
@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo=new UserInfo();
	private UserManager um;	
	public UserManager getUm() {		
		return um;
	}
	@Resource(name="UserManager")
	public void setUm(UserManager um) {
		this.um = um;	
	}

	@Override
	public String execute() throws Exception{		
		User u=new User(userInfo);		
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

	@Override
	public Object getModel(){
		return userInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
