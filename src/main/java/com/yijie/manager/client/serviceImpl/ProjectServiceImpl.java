package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.ProjectDao;
import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;
import com.yijie.manager.client.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;

	@Override
	public Integer projectBuild(Projects projects) {
		// TODO Auto-generated method stub
		return projectDao.projectBuild(projects);
	}

	@Override
	public List<Projects> projectTable(Projects projects) {
		// TODO Auto-generated method stub
		return projectDao.projectTable(projects);
	}

	@Override
	public Projects projectMessage(Projects projects) {
		return projectDao.projectMessage(projects);
	}

	@Override
	public Integer projectUpdate(Projects projects) {
		// TODO Auto-generated method stub
		return projectDao.projectUpdate(projects);
	}

	@Override
	public Integer projectDelete(Projects projects) {
		// TODO Auto-generated method stub
		return projectDao.projectDelete(projects);
	}

	@Override
	public Integer projectDesignAdd(List<ProjectDesign> projectDesign) {
		// TODO Auto-generated method stub
		return projectDao.projectDesignAdd(projectDesign);
	}

	@Override
	public Integer projectDesignUpdate(List<ProjectDesign> projectDesign) {
		// TODO Auto-generated method stub
		return projectDao.projectDesignUpdate(projectDesign);
	}

	@Override
	public Integer projectDesignDelete(ProjectDesign projectDesign) {
		// TODO Auto-generated method stub
		return projectDao.projectDesignDelete(projectDesign);
	}

	@Override
	public Integer projectCount(Projects projects) {
		// TODO Auto-generated method stub
		return projectDao.projectCount(projects);
	}

}
