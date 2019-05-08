package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;


/**
 * @描述 项目执行模块
 * @author Lucifer
 *
 */
public interface ProjectService {

	// 创建项目
	public Integer projectBuild(Projects projects);

	// 项目列表
	public List<Projects> projectTable(Projects projects);

	// 项目详细信息
	public Projects projectMessage(Projects projects);

	// 项目信息更新
	public Integer projectUpdate(Projects projects);

	// 删除项目
	public Integer projectDelete(Projects projects);

	// 项目附件添加
	public Integer projectDesignAdd(List<ProjectDesign> projectDesign);

	// 项目附件修改
	public Integer projectDesignUpdate(List<ProjectDesign> projectDesign);

	// 项目附件删除
	public Integer projectDesignDelete(ProjectDesign projectDesign);
	
	// 查询项目条数
	public Integer projectCount(Projects projects);

}
