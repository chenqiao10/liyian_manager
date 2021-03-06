package com.yijie.manager.client.controller;

import java.util.Date;
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

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.service.AdminService;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.utils.Uuid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
//		String msg = null;
		// Shiro认证登录
		Subject subject = SecurityUtils.getSubject();
		Md5Hash hash = new Md5Hash(admin.getPassword(), admin.getNum(), 2);
		AuthenticationToken token = new UsernamePasswordToken(admin.getNum(), hash.toString());
		System.out.println(token);
		try {
			subject.login(token);
			Admin a = (Admin) subject.getPrincipal();
			if (a.getStatus() != 1) {
				result.put("code", 0);
				result.put("msg", "已禁用");
			} else {
				result.put("code", 1);
				result.put("admin", a);
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

	/**
	 * 管理账户信息添加
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminInsert")
	public Map<String, Object> adminInsert(@RequestBody Admin admin) {
		System.out.println(admin);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Md5Hash hash = new Md5Hash(admin.getPassword(), admin.getNum(), 2);
			admin.setUuid(Uuid.getUuid());
			admin.setPassword(hash.toString());
			admin.setStatus(1);// 1正常
			Integer code = adminService.adminInsert(admin);
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
		}
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
		try {
			if (admin.getId() != null || admin.getUuid() != null) {
				if (admin.getPassword() != null && admin.getNum() != null) {
					Md5Hash hash = new Md5Hash(admin.getPassword(), admin.getNum(), 2);
					admin.setPassword(hash.toString());
				}
				Integer code = adminService.adminUpdate(admin);
				map.put("code", code);
			}else {
				map.put("code", 0);
				map.put("msg", "系统错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
		}
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
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = adminService.adminDelete(admin);
			sb.append("管理员账户   ");
			sb.append(admin.getNum());
			if (code == 0) {
				sb.append(" 删除失败");
			} else if (code == 1) {
				sb.append(" 删除成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(admin.getHandle_name());
			safeLog.setHandle_id(admin.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
		}
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

	/**
	 * 管理员账户信息批量修改
	 * 
	 * @param adminList
	 * @return
	 */
	@RequestMapping("/adminUpdateAll")
	public Map<String, Object> adminUpdateAll(@RequestBody JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray jsonArray = json.getJSONArray("adminList");
		List<Admin> adminList = (List<Admin>) jsonArray.toCollection(jsonArray, Admin.class);
		try {
			for (int i = 0; i < adminList.size(); i++) {
				System.out.println(adminList.get(i));
				StringBuffer sb = new StringBuffer();
				Integer code = adminService.adminUpdate(adminList.get(i));
				sb.append("禁用管理员账户	");
				sb.append(adminList.get(i).getNum());
				if (code == 0) {
					sb.append("	失败");
				} else if (code == 1) {
					sb.append("	成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(adminList.get(i).getHandle_name());
				safeLog.setHandle_id(adminList.get(i).getHandle_id());
				safeLog.setHandle(sb.toString());
				safeLog.setHandle_date(new Date());
				safeLogService.safeLogAdd(safeLog);
				map.put("code", code);
			}
		} catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * 管理员账户信息条数
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping("/adminCount")
	public Map<String, Object> adminCount(@RequestBody Admin admin) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer count = adminService.adminCount(admin);
			map.put("code", 1);
			map.put("count", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "系统出错");
		}
		return map;
	}

}
