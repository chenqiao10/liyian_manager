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

/**
 * 管理员账户模块
 * 
 * @author sunzhu
 *
 */
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
	public Map<String, Object> adminLogin(@RequestBody Admin admin){
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
	
	/**
	 * 管理账户信息添加
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminInsert")
	public Map<String, Object> adminInsert(@RequestBody Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminInsert(admin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 管理员账户信息修改
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminUpdate")
	public Map<String, Object> adminUpdate(Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminUpdate(admin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 管理员账户信息删除
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminDelete")
	public Map<String, Object> adminDelete(Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminDelete(admin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 管理员账户信息查询
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminSelect")
	public Map<String, Object> adminTable(Admin admin){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Admin> list = adminService.adminTable(admin);
			map.put("code", 1);
			map.put("data", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "系统出错");
		}
		return map;
	}
}
