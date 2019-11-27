package com.zzuli.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzuli.domain.Role;
import com.zzuli.mapper.RoleMapper;
import com.zzuli.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<String> queryRolesByUserId(Integer userId) {
		List<Role> list = roleMapper.queryRolesByUserId(userId);
		List<String> roles=new ArrayList<>();
		for (Role role : list) {
			roles.add(role.getRolename());
		}
		return roles;
	}

}
