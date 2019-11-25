package com.zzuli.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.domain.Permission;
import com.zzuli.mapper.PermissionMapper;
import com.zzuli.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<String> queryPermissionByUserId(Integer userId) {
		List<Permission> list = permissionMapper.queryPermissionByUserId(userId);
		List<String> perimssions = new ArrayList<>();
		for (Permission permission : list) {
			perimssions.add(permission.getPercode());
		}
		return perimssions;
	}

}
