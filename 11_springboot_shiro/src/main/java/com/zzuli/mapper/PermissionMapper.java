package com.zzuli.mapper;

import java.util.List;

import com.zzuli.domain.Permission;

public interface PermissionMapper {

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    List<Permission> queryPermissionByUserId(Integer userId);
}
