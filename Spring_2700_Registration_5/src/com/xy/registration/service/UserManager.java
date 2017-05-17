package com.xy.registration.service;

import com.xy.registration.model.User;

public interface UserManager {

	public abstract boolean exists(User u) throws Exception;

	public abstract void add(User u);

}