package com.aaa.javademo.dao;

import com.aaa.javademo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseDao<User, Long> {

	public List<User> findByUserName(String userName);

	@Query(value = "select user_name, age from base_user where user_name = ?1 and age = ?2", nativeQuery = true)
	public List<Map<String, Object>> listByparams(String userName, Integer age);
}
