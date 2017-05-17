package com.bjsxt.dao.impl;

import org.springframework.stereotype.Component;
import com.bjsxt.model.User;
import com.bjsxt.dao.*;

@Component("u")
public class UserDAOImpl implements UserDAO{
	private int daoId;
	public int getDaoId() {
		return daoId;
	}
	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}
	@Override
	public void save(User u){
		System.out.println("a user saved");
	}
	@Override
	public String toString(){
		return "dao "+daoId;
	}
}
