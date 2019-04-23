package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.AdcolumnDao;
import com.yijie.manager.client.model.Adcolumn;
import com.yijie.manager.client.service.AdcolumnService;

/**
 * 广告轮播模块
 * 
 * @author sunzhu
 *
 */
@Service
public class AdcolumnServiceImpl implements AdcolumnService{
	
	@Autowired
	private AdcolumnDao adcolumnDao;

	@Override
	public List<Adcolumn> adcolumnSelect(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return adcolumnDao.adcolumnSelect(adcolumn);
	}

	@Override
	public Integer adcolumnDelete(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return adcolumnDao.adcolumnDelete(adcolumn);
	}

	@Override
	public Integer adcolumnUpdate(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return adcolumnDao.adcolumnUpdate(adcolumn);
	}

	@Override
	public Integer adcolumnInsert(Adcolumn adcolumn) {
		// TODO Auto-generated method stub
		return adcolumnDao.adcolumnInsert(adcolumn);
	}

}
