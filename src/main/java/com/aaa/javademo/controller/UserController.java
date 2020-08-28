package com.aaa.javademo.controller;

import com.aaa.javademo.common.Result;
import com.aaa.javademo.model.User;
import com.aaa.javademo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user/")
public class UserController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "index",method = RequestMethod.GET)
	public Result<List<User>> index(User user) {
		Result<List<User>> rs = new Result<List<User>>();
		rs.setData(userService.listAll());
		return rs;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public Result<User> add(@Valid User user) {
		Result<User> rs = new Result<User>();
		userService.add(user);
		rs.setData(user);
		return rs;
	}

	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public Result<User> remove(Long id) {
		log.debug(msg("参数id=" + id));
		Result<User> rs = new Result<User>();
		userService.delete(id);
		return rs;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public Result<User> modify(User user) {
		Result<User> rs = new Result<User>();
		userService.update(user);
		rs.setData(user);
		return rs;
	}

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public Result<User> show(Long id) {
		Result<User> rs = new Result<User>();
		return rs;
	}
}
