package com.xy.registration.service.impl;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.xy.registration.dao.UserDao;
import com.xy.registration.dao.impl.UserDaoImpl;
import com.xy.registration.model.User;
import com.xy.registration.service.UserManager;
@Component("UserManager")
@Scope("prototype")
public class UserManagerImpl implements UserManager {
	private UserDao userDao=new UserDaoImpl();
	/* (non-Javadoc)
	 * @see com.xy.registration.service.impl.UserManager#exists(com.xy.registration.model.User)
	 */
	@Override
	public boolean exists(User u) throws Exception{
		return userDao.checkUserExistsWithName(u.getUsername());
	}
	/* (non-Javadoc)
	 * @see com.xy.registration.service.impl.UserManager#add(com.xy.registration.model.User)
	 */
	@Override
	public void add(User u){
		userDao.save(u);
	}

}
