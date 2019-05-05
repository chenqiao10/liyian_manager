package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.UserChangeProject;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserChangeProjectService;

/**
 * 用户交互的项目
 * 
 * @author chenqiao
 *
 */
@RestController
@RequestMapping("/user")
public class UserChangeProjectController {
	@Autowired
	private UserChangeProjectService userChangeProjectService;
	@Autowired
	private SafeLogService safeLogService;

	// 用户已交换项目列表
	@RequestMapping("/userCheProTable")
	public Map<String, Object> userCheProTable(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<UserChangeProject> list = userChangeProjectService.userCheProTable(userChangeProject);
			result.put("list", list);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}

	}

	/**
	 * 
	 * 项目添加
	 * 
	 * @param userChangeProject
	 * @return
	 */
	@RequestMapping("/userCheProAdd")
	public Map<String, Object> userCheProAdd(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = userChangeProjectService.userCheProAdd(userChangeProject);
			String msg = "";
			if (code == 0) {
				msg = "用户交换项目添加失败";
			} else if (code == 1) {
				msg = "用户交换项目添加成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(userChangeProject.getHandle_name());
			safeLog.setHandle_id(userChangeProject.getHandle_id());
			safeLog.setHandle(msg);
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	/**
	 * 
	 * 用户交换项目删除
	 * 
	 * @param userChangeProject
	 * @return
	 */
	@RequestMapping("/userCheProDelete")
	public Map<String, Object> userCheProDelete(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = userChangeProjectService.userCheProDelete(userChangeProject);
			String msg = "";
			if (code == 0) {
				msg = "用户交换项目删除失败";
			} else if (code == 1) {
				msg = "用户交换项目删除成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(userChangeProject.getHandle_name());
			safeLog.setHandle_id(userChangeProject.getHandle_id());
			safeLog.setHandle(msg);
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

}
