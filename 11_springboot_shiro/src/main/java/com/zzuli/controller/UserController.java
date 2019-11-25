package com.zzuli.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制器
 *
 * @author LJH
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	/**
	 * 跳转到用户管理的页面
	 */
	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "list";
	}

	@RequestMapping("query")
	@ResponseBody
	public Map<String,Object> query(){
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "query");
		return map;
	}
	@RequestMapping("add")
	@ResponseBody
	public Map<String,Object> add(){
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "add");
		return map;
	}
	@RequestMapping("update")
	@ResponseBody
	public Map<String,Object> update(){
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "update");
		return map;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(){
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "delete");
		return map;
	}

	@RequestMapping("export")
	@ResponseBody
	public Map<String,Object> export(){
		Map<String,Object> map=new HashMap<>();
		map.put("msg", "export");
		return map;
	}


}
