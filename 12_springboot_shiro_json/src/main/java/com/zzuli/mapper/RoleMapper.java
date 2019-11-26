package com.zzuli.mapper;

import java.util.List;

import com.zzuli.domain.Role;

public interface RoleMapper {

    /**
     * 查询用户ID查询角色
     * @param userId
     * @return
     */
	List<Role> queryRolesByUserId(Integer userId);
}
