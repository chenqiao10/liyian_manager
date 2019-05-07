package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Message;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.SuperAdmin;
import com.yijie.manager.client.service.MessageService;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.SuperAdminService;

@RestController
@RequestMapping("/admin")
public class SuperAdminController {
	
	@Autowired
	private SuperAdminService superAdminService;
	
	@Autowired
	private SafeLogService safeLogService;
	
	/**
	 * @  添加超级管理员
	 * @param superAdmin
	 * @return
	 */
	@RequestMapping("/superAdminInsert")
	public Map<String, Object> superAdminInsert(@RequestBody SuperAdmin superAdmin){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = superAdminService.superAdminInsert(superAdmin);
		String msg = "";
		if (code == 0) {
			msg = "添加超级管理员失败";
		} else if (code == 1) {
			msg = "添加超级管理员成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(superAdmin.getHandle_name());
		safeLog.setHandle_id(superAdmin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
		String msg = "";
		if (code == 0) {
			msg = "删除管理员失败";
		} else if (code == 1) {
			msg = "删除管理员成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(superAdmin.getHandle_name());
		safeLog.setHandle_id(superAdmin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
		String msg = "";
		if (code == 0) {
			msg = "修改管理员信息失败";
		} else if (code == 1) {
			msg = "修改管理员信息成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(superAdmin.getHandle_name());
		safeLog.setHandle_id(superAdmin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
}
