package com.zzuli.mapper;

import org.apache.ibatis.annotations.Param;

import com.zzuli.domain.User;

public interface UserMapper {
    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
	User queryUserByUserName(@Param("username") String username);
}
