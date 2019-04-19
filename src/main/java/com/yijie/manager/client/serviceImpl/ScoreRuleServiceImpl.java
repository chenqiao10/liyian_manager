package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.ScoreDao;
import com.yijie.manager.client.model.ScoreRule;
import com.yijie.manager.client.service.ScoreRuleService;


@Service
public class ScoreRuleServiceImpl implements ScoreRuleService {
	@Autowired
	ScoreDao scoreDao;

	@Override
	public List<ScoreRule> scoreRuleSelect(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return scoreDao.scoreRuleSelect(ScoreRule);
	}

	@Override
	public Integer scoreRuleAdd(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return scoreDao.scoreRuleAdd(ScoreRule);
	}

	@Override
	public Integer scoreRuleUpdate(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return scoreDao.scoreRuleUpdate(ScoreRule);
	}

	@Override
	public Integer scoreRuleDelete(ScoreRule ScoreRule) {
		// TODO 自动生成的方法存根
		return scoreDao.scoreRuleDelete(ScoreRule);
	}

}
