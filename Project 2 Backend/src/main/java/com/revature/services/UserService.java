package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserService {
	UserDao uDao = new UserDao();

	public User getUserByUsername(String username) {
		User u = uDao.findUserByUsername(username);
		return u;
	}

	public User getUserByUserid(int userid) {
		User u = uDao.findUserByUserid(userid);
		return u;
	}

}
