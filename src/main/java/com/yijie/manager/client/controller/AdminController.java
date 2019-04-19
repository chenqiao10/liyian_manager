package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 管理账户模块
 * 
 * @author sunzhu
 *
 */
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminLogin")
	public Map<String, Object> adminTable(@RequestBody Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		Admin a = adminService.adminLogin(admin);
		if(a == null) {
			map.put("code", 0);
			map.put("msg", "账号不存在或密码错误！");
		}else {
			map.put("code", 1);
			map.put("msg", "登陆成功！");
		}
		return map;
	}
	
	@RequestMapping("/adminAdd")
	public Map<String, Object> adminAdd(@RequestBody Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminInsert(admin);
		map.put("code", code);
		return map;
	}
	
}
