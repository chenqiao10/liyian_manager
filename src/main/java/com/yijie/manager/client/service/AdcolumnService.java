package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.Adcolumn;

/**
 * 广告轮播模块
 * 
 * @author sunzhu
 *
 */
public interface AdcolumnService {
	
	//管理员信息查询
	public List<Adcolumn> adcolumnSelect(Adcolumn adcolumn);
	
	//管理员信息删除
	public Integer adcolumnDelete(Adcolumn adcolumn);
	
	//管理员信息修改
	public Integer adcolumnUpdate(Adcolumn adcolumn);
	
	//添加管理员信息
	public Integer adcolumnInsert(Adcolumn adcolumn);

}
