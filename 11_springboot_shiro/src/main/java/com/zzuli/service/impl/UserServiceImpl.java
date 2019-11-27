package com.zzuli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.domain.User;
import com.zzuli.mapper.UserMapper;
import com.zzuli.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String username) {
		System.out.println();
		return userMapper.queryUserByUserName(username);
	}
}
