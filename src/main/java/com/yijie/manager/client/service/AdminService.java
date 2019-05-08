package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.Admin;
/**
 * 管理账户模块
 * 
 * @author sunzhu
 *
 */
public interface AdminService {
	
	//管理员信息查询
	public List<Admin> adminTable(Admin admin);
	
	//管理员信息查询详情
	public Admin adminLogin(Admin admin);
	
	//管理员信息删除
	public Integer adminDelete(Admin admin);
	
	//管理员信息修改
	public Integer adminUpdate(Admin admin);
	
	//添加管理员信息
	public Integer adminInsert(Admin admin);
	
	//管理员信息批量删除
	public Integer adminDeleteAll(List<Admin> adminList);
	
	//管理员信息条数
	public Integer adminCount(Admin admin);

}
