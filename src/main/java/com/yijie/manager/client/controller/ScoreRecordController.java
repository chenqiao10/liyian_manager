package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.ScoreRecord;
import com.yijie.manager.client.service.ScoreRecordService;
import com.yijie.manager.client.utils.Uuid;

/**
 * 积分记录
 * 
 * @author sunzhu
 *
 */
@RestController
@RequestMapping("/user")
public class ScoreRecordController {
	
	@Autowired
	private ScoreRecordService scoreRecordService;
	
	/**
	 * 积分记录查询
	 * @param scoreRecord
	 * @return
	 */
	@RequestMapping("/ScoreRecordSelect")
	public Map<String, Object> ScoreRecordSelect(@RequestBody ScoreRecord scoreRecord){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<ScoreRecord> scoreRecordlist = scoreRecordService.scoreRecordTable(scoreRecord);
			result.put("scoreRecordlist", scoreRecordlist);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	/**
	 * 添加积分记录
	 * @param scoreRecord
	 * @return
	 */
	@RequestMapping("/ScoreRecordInsert")
	public Map<String, Object> ScoreRecordInsert(@RequestBody ScoreRecord scoreRecord){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			scoreRecord.setUuid(Uuid.getUuid());
			Integer code = scoreRecordService.scoreRecordAdd(scoreRecord);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	/**
	 * 删除积分记录
	 * @param scoreRecord
	 * @return
	 */
	@RequestMapping("/ScoreRecordDelete")
	public Map<String, Object> ScoreRecordDelete(@RequestBody ScoreRecord scoreRecord){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = scoreRecordService.scoreRecordDelete(scoreRecord);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	/**
	 * 修改积分记录
	 * @param scoreRecord
	 * @return
	 */
	@RequestMapping("/ScoreRecordUpdate")
	public Map<String, Object> ScoreRecordUpdate(@RequestBody ScoreRecord scoreRecord){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = scoreRecordService.scoreRecordUpdate(scoreRecord);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

}
