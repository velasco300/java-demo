package com.aaa.javademo.dao;

import com.aaa.javademo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseDao<User, Long> {

	public List<User> findByUserNameOrderByIdDesc(String userName);

	@Query(value = "select user_name, age from base_user where user_name = ?1 and age = ?2", nativeQuery = true)
	public List<Map<String, Object>> listByparams(String userName, Integer age);

	@Query("select new map(u.id as id, u.age as age) from User u join Role r on u.id = r.userId join Menu m on r.id = m.roleId where u.age > :age and r.id = :rid and m.id = :mid")
	public List<Map<String,Object>> listExamp(Integer age,Long rid,Long mie);
}
