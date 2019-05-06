package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.service.AdminService;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.utils.Uuid;

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
	@Autowired
	private SafeLogService safeLogService;

	/**
	 * @描述 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/adminLogin")
	public Map<String, Object> adminLogin(@RequestBody Admin admin) {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = null;
		if (admin.getNum() != null && admin.getPassword() != null) {// 根据电话号登录
			Admin a = adminService.adminLogin(admin);
			if (a == null) {
				result.put("code", 0);
				msg = "账户不存在或密码错误！";
			} else {
				result.put("code", 1);
				msg = "登录成功！";
			}
			result.put("admin", a);
			result.put("msg", msg);
			return result;
		} else {
			result.put("code", 0);
			msg = "账户不存在或密码错误！";
			return result;
		}
	}

	/**
	 * 管理账户信息添加
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminInsert")
	public Map<String, Object> adminInsert(@RequestBody Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		admin.setUuid(Uuid.getUuid());
		Integer code = adminService.adminInsert(admin);
		String msg = "";
		if (code == 0) {
			msg = "管理员账户信息添加失败";
		} else if (code == 1) {
			msg = "管理员账户信息添加成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(admin.getHandle_name());
		safeLog.setHandle_id(admin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
	public Map<String, Object> adminUpdate(@RequestBody Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminUpdate(admin);
		String msg = "";
		if (code == 0) {
			msg = "管理员账户信息修改失败";
		} else if (code == 1) {
			msg = "管理员账户信息修改成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(admin.getHandle_name());
		safeLog.setHandle_id(admin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
	public Map<String, Object> adminDelete(@RequestBody Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adminService.adminDelete(admin);
		String msg = "";
		if (code == 0) {
			msg = "管理员账户信息删除失败";
		} else if (code == 1) {
			msg = "管理员账户信息删除成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(admin.getHandle_name());
		safeLog.setHandle_id(admin.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
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
	public Map<String, Object> adminTable(@RequestBody Admin admin) {
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
