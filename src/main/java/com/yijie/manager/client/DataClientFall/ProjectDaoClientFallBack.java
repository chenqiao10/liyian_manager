package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.ProjectDao;
import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;

@Component
public class ProjectDaoClientFallBack implements ProjectDao {

	@Override
	public Projects projectMessage(Projects pro) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Projects> projectTable(Projects pro) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer projectBuild(Projects pro) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectDelete(Projects pro) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectUpdate(Projects pro) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectDesignAdd(List<ProjectDesign> projectDesign) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectDesignUpdate(List<ProjectDesign> projectDesign) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectDesignDelete(ProjectDesign projectDesign) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer projectCount(Projects projects) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer projectDeleteAll(List<Projects> projectsList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
