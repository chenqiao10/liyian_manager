package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.ScoreRecord;

/**
 * 
 * 积分记录
 * @author sunzhu
 *
 */
public interface ScoreRecordService {
	
	//添加积分记录
	public Integer scoreRecordAdd(ScoreRecord scoreRecord);
	
	//积分记录查询
	public List<ScoreRecord> scoreRecordTable(ScoreRecord scoreRecord);
	
	//积分记录修改
	public Integer scoreRecordUpdate(ScoreRecord scoreRecord);
	
	//积分记录删除
	public Integer scoreRecordDelete(ScoreRecord scoreRecord);

}
