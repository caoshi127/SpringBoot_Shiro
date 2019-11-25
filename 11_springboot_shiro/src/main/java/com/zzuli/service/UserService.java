package com.zzuli.service;

import com.zzuli.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户对象
	 */
	User queryUserByUserName(String username);
}
