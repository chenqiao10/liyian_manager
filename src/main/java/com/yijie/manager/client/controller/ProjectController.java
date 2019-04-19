package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;
import com.yijie.manager.client.service.ProjectService;


/**
 * @描述 项目执行模块
 * @author Lucifer
 *
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * @描述 创建项目
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectBuild")
	@ResponseBody
	public Map<String,Object> projectBuild(@RequestBody Projects projects){
		Map<String,Object> result = new HashMap<String, Object>();
		Integer code = projectService.projectBuild(projects);
		result.put("code", code);
		return result;
	}
	
	/**
	 * @描述 项目列表
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectTable")
	@ResponseBody
	public Map<String,Object>   projectTable(@RequestBody Projects projects){
		System.out.println(projects);
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			List<Projects> projectTable = projectService.projectTable(projects);
			result.put("projectTable", projectTable);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
		
	}
	
	/**
	 * @描述 项目详细信息
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectMessage")
	@ResponseBody
	public Map<String,Object> projectMessage(@RequestBody Projects projects){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Projects project = projectService.projectMessage(projects);
			result.put("projectMessage", project);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	
	/**
	 * @描述 项目信息更新
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectUpdate")
	@ResponseBody
	public Map<String,Object> projectUpdate(@RequestBody Projects projects){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Integer code = projectService.projectUpdate(projects);
			result.put("projectMessage", code);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	
	/**
	 * @描述 项目删除
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectDelete")
	@ResponseBody
	public Map<String,Object> projectDelete(@RequestBody Projects projects){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Integer code = projectService.projectDelete(projects);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	
	/**
	 * @描述 项目附件添加
	 * @param projectDesigns
	 * @return
	 */
	@RequestMapping("/projectDesignAdd")
	@ResponseBody
	public Map<String,Object> projectDesignAdd(@RequestBody List<ProjectDesign> projectDesigns){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Integer code = projectService.projectDesignAdd(projectDesigns);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	
	/**
	 * @描述 项目附件修改
	 * @param projectDesigns
	 * @return
	 */
	@RequestMapping("/projectDesignUodate")
	@ResponseBody
	public Map<String,Object> projectDesignUodate(@RequestBody List<ProjectDesign> projectDesigns){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Integer code = projectService.projectDesignUpdate(projectDesigns);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	
	/**
	 * @描述 项目附件删除
	 * @param projectDesigns
	 * @return
	 */
	@RequestMapping("/projectDesignDelete")
	@ResponseBody
	public Map<String,Object> projectDesignDelete(@RequestBody ProjectDesign projectDesign){
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			Integer code = projectService.projectDesignDelete(projectDesign);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

}
