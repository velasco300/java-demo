package com.aaa.javademo.service;

import com.aaa.javademo.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService<User, Long> {

	public List<User> listByUserName(String userName);
	
	public List<Map<String, Object>> listByparams(String userName, Integer age);

	public void addMyUser(User entity);
}
