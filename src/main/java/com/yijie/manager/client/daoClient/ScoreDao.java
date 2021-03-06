package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.ScoreDaoClientFallBack;
import com.yijie.manager.client.model.ScoreRecord;
import com.yijie.manager.client.model.ScoreRule;

/**
 * 
 * 积分记录接口 积分策略接口
 * 
 * @author sunzhu
 *
 */
@FeignClient(name = "yijie.zuul.api", fallback = ScoreDaoClientFallBack.class)
public interface ScoreDao {
	/*
	 * //积分记录查询
	 * 
	 * @RequestMapping("/user/ScoreRecordSelect") public List<ScoreRecord>
	 * scoreRecordSelect(ScoreRecord scoreRecord);
	 * 
	 * //积分记录添加
	 * 
	 * @RequestMapping("/user/ScoreRecordInsert") public Integer
	 * scoreRecordInsert(ScoreRecord scoreRecord);
	 * 
	 * //积分记录更新
	 * 
	 * @RequestMapping("/user/ScoreRecordDelete") public Integer
	 * scoreRecordUpdate(ScoreRecord scoreRecord);
	 * 
	 * //积分记录删除
	 * 
	 * @RequestMapping("/user/ScoreRecordUpdate") public Integer
	 * scoreRecordDelete(ScoreRecord scoreRecord);
	 * 
	 */
	@RequestMapping("/yilianData/user/scoreRuleSelect")
	public List<ScoreRule> scoreRuleSelect(ScoreRule ScoreRule);

	@RequestMapping("/yilianData/user/scoreRuleAdd")
	public Integer scoreRuleAdd(ScoreRule ScoreRule);

	@RequestMapping("/yilianData/user/scoreRuleUpdate")
	public Integer scoreRuleUpdate(ScoreRule ScoreRule);

	@RequestMapping("/yilianData/user/scoreRuleDelete")
	public Integer scoreRuleDelete(ScoreRule ScoreRule);

	/**
	 * 
	 * 积分记录接口
	 * 
	 * @author sunzhu
	 *
	 */

	// 积分记录查询
	@RequestMapping("/yilianData/user/scoreRecordSelect")
	public List<ScoreRecord> scoreRecordSelect(ScoreRecord scoreRecord);

	// 积分记录添加
	@RequestMapping("/yilianData/user/scoreRecordInsert")
	public Integer scoreRecordInsert(ScoreRecord scoreRecord);

	// 积分记录更新
	@RequestMapping("/yilianData/user/scoreRecordUpdate")
	public Integer scoreRecordUpdate(ScoreRecord scoreRecord);

	// 积分记录删除
	@RequestMapping("/yilianData/user/scoreRecordDelete")
	public Integer scoreRecordDelete(ScoreRecord scoreRecord);

	@RequestMapping("/yilianData/user/scoreRecordCount")
	public Integer ScoreRecordCount(ScoreRecord scoreRecord);

}
