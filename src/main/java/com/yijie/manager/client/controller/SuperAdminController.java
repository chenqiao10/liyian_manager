package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.SuperAdmin;
import com.yijie.manager.client.service.SuperAdminService;
import com.yijie.manager.client.utils.Uuid;

@RestController
@RequestMapping("/admin")
public class SuperAdminController {
	
	@Autowired
	private SuperAdminService superAdminService;
	
	/**
	 * @  添加超级管理员
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("/superAdminInsert")
	public Map<String, Object> superAdminInsert(@RequestBody SuperAdmin superAdmin){
		Map<String, Object> map = new HashMap<String, Object>();
		Md5Hash hash = new Md5Hash(superAdmin.getPassword(), superAdmin.getNum(), 3);
		superAdmin.setPassword(hash.toString());
		superAdmin.setStatus(1);//1默认正常使用
		superAdmin.setUuid(Uuid.getUuid());
		Integer code = superAdminService.superAdminInsert(superAdmin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 删除管理员
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("superAdminDelete")
	public Map<String, Object> superAdminDelete(@RequestBody SuperAdmin superAdmin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = superAdminService.superAdminDelete(superAdmin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 修改管理员信息
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("superAdminUpdate")
	public Map<String, Object> superAdminUpdate(@RequestBody SuperAdmin superAdmin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = superAdminService.superAdminUpdate(superAdmin);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 管理员账户列表
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("/superAdminSelect")
	public Map<String, Object> superAdminSelect(@RequestBody SuperAdmin superAdmin){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SuperAdmin> salist = superAdminService.superAdminSelect(superAdmin);
			map.put("salist", salist);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "系统出错");
		}
		return map;
	}
	
	/**
	 * @ 超级管理员登录
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("/superAdminLogin")
	public Map<String, Object> superAdminLogin(@RequestBody SuperAdmin superAdmin) {
		Map<String, Object> result = new HashMap<String, Object>();
//		String msg = null;
		// Shiro认证登录
		Subject subject = SecurityUtils.getSubject();
		Md5Hash hash = new Md5Hash(superAdmin.getPassword(), superAdmin.getNum(), 3);
		System.out.println(hash.toString());
		System.out.println(superAdmin.getNum());
		System.out.println(superAdmin.getNum());
		AuthenticationToken token = new UsernamePasswordToken(superAdmin.getNum(), hash.toString());
		try {
			subject.login(token);
			SuperAdmin sadmin = (SuperAdmin) subject.getPrincipal();
			System.out.println(sadmin);
			if (sadmin.getStatus() != 1) {
				result.put("code", 0);
				result.put("msg", "已禁用");
			} else {
				result.put("code", 1);
				result.put("sadmin",sadmin);
				result.put("msg", "登录成功");
			}
			return result;
		} catch (UnknownAccountException e) {
			result.put("code", 0);
			result.put("msg", "账户不存在");
			return result;
		} catch (IncorrectCredentialsException e) {
			result.put("code", 0);
			result.put("msg", "密码错误");
			return result;
		}
	}
}
