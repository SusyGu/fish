package com.njupt.service;

import java.sql.SQLException;

import com.njupt.dao.UserDao;
import com.njupt.domain.User;

public class UserService {

	public void regist(User user) throws SQLException {
		
		UserDao userDao = new UserDao();
		userDao.regist(user);
		
	}

	public User login(String username, String password) throws SQLException {
		UserDao userDao = new UserDao();
		User user = userDao.login(username,password);
		return user;
	}

}
