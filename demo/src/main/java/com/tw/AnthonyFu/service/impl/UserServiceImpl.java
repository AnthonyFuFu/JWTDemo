package com.tw.AnthonyFu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.AnthonyFu.dao.UserDao;
import com.tw.AnthonyFu.model.User;
import com.tw.AnthonyFu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	public User login(User user) {
		User login = userDao.login(user);
		if (login != null) {
			return login;
		}
		throw new RuntimeException("登入失敗~~");
	}
}