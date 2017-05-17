package com.xy.registration.dao;

import com.xy.registration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean checkUserExistsWithName(String username);
}
