package com.smh.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.login.mapper.UserMapper;
import com.smh.login.model.User;
import com.smh.login.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;//注入dao

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

}
