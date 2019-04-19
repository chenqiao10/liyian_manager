package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.ScoreRule;
import com.yijie.manager.client.service.ScoreRuleService;


@RestController
@RequestMapping("/user")
public class ScoreRuleController {
	
	@Autowired
	ScoreRuleService ScoreRuleService;
	
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
			Integer code = ScoreRuleService.scoreRuleAdd(ScoreRule);

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
