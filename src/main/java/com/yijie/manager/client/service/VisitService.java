package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.Visit;

/**
 * @用户访问量
 * @author sunzhu
 *
 */
public interface VisitService {
	
	//添加用户访问记录
	public Integer visitAdd(Visit visit);
	
	//用户访问记录查询
	public List<Visit> visitTable(Visit visit);
	
	//用户访问记录修改
	public Integer visitUpdate(Visit visit);

}
