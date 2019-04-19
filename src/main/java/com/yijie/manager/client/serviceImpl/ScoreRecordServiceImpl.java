package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.ScoreDao;
import com.yijie.manager.client.model.ScoreRecord;
import com.yijie.manager.client.service.ScoreRecordService;


@Service
public class ScoreRecordServiceImpl implements ScoreRecordService{
	
	@Autowired
	private ScoreDao  scoreRecordDao;

	@Override
	public Integer scoreRecordAdd(ScoreRecord scoreRecord) {
		// TODO Auto-generated method stub
		return scoreRecordDao.scoreRecordInsert(scoreRecord);
	}

	@Override
	public List<ScoreRecord> scoreRecordTable(ScoreRecord scoreRecord) {
		// TODO Auto-generated method stub
		return scoreRecordDao.scoreRecordSelect(scoreRecord);
	}

	@Override
	public Integer scoreRecordUpdate(ScoreRecord scoreRecord) {
		// TODO Auto-generated method stub
		return scoreRecordDao.scoreRecordUpdate(scoreRecord);
	}

	@Override
	public Integer scoreRecordDelete(ScoreRecord scoreRecord) {
		// TODO Auto-generated method stub
		return scoreRecordDao.scoreRecordDelete(scoreRecord);
	}

}
