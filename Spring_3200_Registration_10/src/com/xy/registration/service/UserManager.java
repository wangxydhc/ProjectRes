package com.xy.registration.service;

import java.util.List;

import com.xy.registration.model.User;

public interface UserManager {

	public abstract boolean exists(User u) throws Exception;
	public abstract void add(User u);
	public abstract List<User> getUsers();
	public abstract User getUser(int id);

}