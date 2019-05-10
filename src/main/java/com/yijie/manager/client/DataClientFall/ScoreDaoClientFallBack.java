package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.ScoreDao;
import com.yijie.manager.client.model.ScoreRecord;
import com.yijie.manager.client.model.ScoreRule;


@Component
public class ScoreDaoClientFallBack implements ScoreDao{

	@Override
	public List<ScoreRule> scoreRuleSelect(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer scoreRuleAdd(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer scoreRuleUpdate(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer scoreRuleDelete(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List<ScoreRecord> scoreRecordSelect(ScoreRecord scoreRecord) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer scoreRecordInsert(ScoreRecord scoreRecord) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer scoreRecordUpdate(ScoreRecord scoreRecord) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer scoreRecordDelete(ScoreRecord scoreRecord) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer ScoreRecordCount(ScoreRecord scoreRecord) {
		// TODO 自动生成的方法存根
		return null;
	}

}
