package com.bjsxt.dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.bjsxt.model.User;


public interface UserDAO {
	public void save(User u);
}
