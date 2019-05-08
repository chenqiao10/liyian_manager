package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.UserChangeProject;

/**
 * 用户项目
 * 
 * @author chenqiao
 *
 */
public interface UserChangeProjectService {

	public List<UserChangeProject> userCheProTable(UserChangeProject userChangeProject);

	public Integer userCheProAdd(UserChangeProject userChangeProject);

	public Integer userCheProDelete(UserChangeProject userChangeProject);

	// 交换项目条数
	public Integer userCheProCount(UserChangeProject userChangeProject);

}
