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
import com.yijie.manager.client.model.ScoreRule;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.ScoreRuleService;
import com.yijie.manager.client.utils.Uuid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	
	/**
	 * 管理员账户信息批量修改
	 * 
	 * @param adminList
	 * @return
	 */
	@RequestMapping("/scoreRuleUpdateAll")
	public Map<String, Object> scoreRuleUpdateAll(@RequestBody JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray jsonArray = json.getJSONArray("scoreRuleList");
		List<ScoreRule> scoreRuleList = (List<ScoreRule>) jsonArray.toCollection(jsonArray, ScoreRule.class);
		try {
			for (int i = 0; i < scoreRuleList.size(); i++) {
				System.out.println(scoreRuleList.get(i));
				StringBuffer sb = new StringBuffer();
				Integer code = ScoreRuleService.scoreRuleUpdate(scoreRuleList.get(i));
				sb.append(scoreRuleList.get(i).getHandle_name());
				if (scoreRuleList.get(i).getStatus() == 0) {
					sb.append("	禁用积分规则");
				} else if (scoreRuleList.get(i).getStatus() == 1) {
					sb.append("	启用禁用积分规则");
				}
				if (code == 0) {
					sb.append("	失败");
				} else if (code == 1) {
					sb.append("	成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(scoreRuleList.get(i).getHandle_name());
				safeLog.setHandle_id(scoreRuleList.get(i).getHandle_id());
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
}
