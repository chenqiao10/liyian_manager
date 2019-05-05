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

	Map<String, Object> result = new HashMap<String, Object>();

	@RequestMapping("/scoreRuleSelect")
	public Map<String, Object> scoreRuleSelect(@RequestBody ScoreRule ScoreRule) {

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

		try {
			ScoreRule.setUuid(Uuid.getUuid());
			Integer code = ScoreRuleService.scoreRuleAdd(ScoreRule);
			String msg = "";
			if (code == 0) {
				msg = "添加积分策略失败";
			} else if (code == 1) {
				msg = "添加积分策略成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
			safeLog.setHandle(msg);
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
		try {
			Integer code = ScoreRuleService.scoreRuleUpdate(ScoreRule);
			String msg = "";
			if (code == 0) {
				msg = "修改积分策略失败";
			} else if (code == 1) {
				msg = "修改积分策略成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
			safeLog.setHandle(msg);
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

		try {
			Integer code = ScoreRuleService.scoreRuleDelete(ScoreRule);
			String msg = "";
			if (code == 0) {
				msg = "积分策略删除失败";
			} else if (code == 1) {
				msg = "积分策略删除成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(ScoreRule.getHandle_name());
			safeLog.setHandle_id(ScoreRule.getHandle_id());
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
