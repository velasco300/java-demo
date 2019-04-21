package com.aaa.javademo.service.impl;

import com.aaa.javademo.dao.UserDao;
import com.aaa.javademo.model.User;
import com.aaa.javademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> listByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public void addMyUser(User entity) {
		userDao.save(entity);
	}

	@Override
	public List<Map<String, Object>> listByparams(String userName, Integer age) {
		return userDao.listByparams(userName, age);
	}

}
