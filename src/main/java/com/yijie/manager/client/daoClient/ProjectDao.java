package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;


/**
 * 项目信息接口
 * 
 * @author chenqiao
 *
 */
@FeignClient("yijie.zuul.api")
public interface ProjectDao {
	// 项目详细信息
	@RequestMapping("/yilianData/project/projectMessage")
	public Projects projectMessage(Projects pro);

	// 项目列表
	@RequestMapping("/yilianData/project/projectTable")
	public List<Projects> projectTable(Projects pro);

	// 项目创建
	@RequestMapping("/yilianData/project/projectBuild")
	public Integer projectBuild(Projects pro);

	// 项目删除
	@RequestMapping("/yilianData/project/projectDelete")
	public Integer projectDelete(Projects pro);

	// 项目修改
	@RequestMapping("/yilianData/project/projectUpdate")
	public Integer projectUpdate(Projects pro);
	
	// 项目附件添加
	@RequestMapping("/yilianData/project/projectDesignAdd")
	public Integer projectDesignAdd(List<ProjectDesign> projectDesign);
	
	// 项目附件修改
	@RequestMapping("/yilianData/project/projectDesignUpdate")
	public Integer projectDesignUpdate(List<ProjectDesign> projectDesign);

	// 项目附件删除
	@RequestMapping("/yilianData/project/projectDesignDelete")
	public Integer projectDesignDelete(ProjectDesign projectDesign);
}
