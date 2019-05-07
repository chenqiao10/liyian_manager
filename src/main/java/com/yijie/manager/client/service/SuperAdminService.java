package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.SuperAdmin;

/**
 * @ 超管信息接口
 * @author sunzhu
 *
 */
public interface SuperAdminService {

	// 超管信息添加
	public Integer superAdminInsert(SuperAdmin superAdmin);

	// 超管信息删除
	public Integer superAdminDelete(SuperAdmin superAdmin);

	// 超管信息修改
	public Integer superAdminUpdate(SuperAdmin superAdmin);

	// 超管信息查询
	public List<SuperAdmin> superAdminSelect(SuperAdmin superAdmin);
	
	//管理员信息查询详情
	public SuperAdmin superAdminLogin(SuperAdmin superAdmin);

}
