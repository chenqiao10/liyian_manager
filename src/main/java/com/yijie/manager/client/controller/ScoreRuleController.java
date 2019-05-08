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
import com.yijie.manager.client.model.ScoreRule;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.ScoreRuleService;
import com.yijie.manager.client.utils.Uuid;

@RestController
@RequestMapping("/user")
public class ScoreRuleController {

	@Autowired
	private ScoreRuleService ScoreRuleService;
	@Autowired
	private SafeLogService safeLogService;

	@RequestMapping("/scoreRuleSelect")
	public Map<String, Object> scoreRuleSelect(@RequestBody ScoreRule ScoreRule) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(ScoreRule);
		try {
			List<ScoreRule> list = ScoreRuleService.scoreRuleSelect(ScoreRule);
			result.put("list", list);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	@RequestMapping("/scoreRuleAdd")
	public Map<String, Object> scoreRuleAdd(@RequestBody ScoreRule ScoreRule) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			ScoreRule.setUuid(Uuid.getUuid());
			Integer code = ScoreRuleService.scoreRuleAdd(ScoreRule);
			sb.append("管理员账户   ");
			sb.append(ScoreRule.getHandle_name());
			if (code == 0) {
				sb.append(" 添加积分策略失败");
			} else if (code == 1) {
				sb.append(" 添加积分策略成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	@RequestMapping("/scoreRuleUpdate")
	public Map<String, Object> scoreRuleUpdate(@RequestBody ScoreRule ScoreRule) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = ScoreRuleService.scoreRuleUpdate(ScoreRule);
			sb.append("管理员账户   ");
			sb.append(ScoreRule.getHandle_name());
			if (code == 0) {
				sb.append(" 修改积分策略失败");
			} else if (code == 1) {
				sb.append(" 修改积分策略成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	@RequestMapping("/scoreRuleDelete")
	public Map<String, Object> scoreRuleDelete(@RequestBody ScoreRule ScoreRule) {
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = ScoreRuleService.scoreRuleDelete(ScoreRule);
			sb.append("管理员账户   ");
			sb.append(ScoreRule.getHandle_name());
			if (code == 0) {
				sb.append(" 删除积分策略失败");
			} else if (code == 1) {
				sb.append(" 删除积分策略成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
			safeLog.setHandle(sb.toString());
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
