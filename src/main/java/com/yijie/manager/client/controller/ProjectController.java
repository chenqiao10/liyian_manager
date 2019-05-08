package com.yijie.manager.client.controller;

import java.util.Date;
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
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.User;
import com.yijie.manager.client.service.ProjectService;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserHandleService;
import com.yijie.manager.client.utils.Uuid;

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
	@Autowired
	private UserHandleService UserHandleService;
	@Autowired
	private SafeLogService safeLogService;

	/**
	 * @描述 创建项目
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectBuild")
	@ResponseBody
	public Map<String, Object> projectBuild(@RequestBody Projects projects) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(projects);
		try {
			projects.setUuid(Uuid.getUuid());
			projects.setAudit(2);// 2审核中
			projects.setDate(new Date());
			Integer code = projectService.projectBuild(projects);
			result.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
		}
		return result;
	}

	/**
	 * @描述 项目列表
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectTable")
	@ResponseBody
	public Map<String, Object> projectTable(@RequestBody Projects projects) {
		System.out.println(projects);
		Map<String, Object> result = new HashMap<String, Object>();
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
	public Map<String, Object> projectMessage(@RequestBody Projects projects) {
		System.out.println(projects);
		Map<String, Object> result = new HashMap<String, Object>();
		if (projects.getId() != null || projects.getUuid() != null) {
			try {
				Projects project = projectService.projectMessage(projects);
				User user = new User();
				user.setUuid(project.getUser_uuid());
				String name = UserHandleService.userLogin(user).getName();
				result.put("projectMessage", project);
				result.put("name", name);
				result.put("code", 1);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				result.put("code", 0);
				result.put("msg", "系统出错");
				return result;
			}
		}
		return result;
	}

	/**
	 * @描述 项目信息更新
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectUpdate")
	@ResponseBody
	public Map<String, Object> projectUpdate(@RequestBody Projects projects) {
		System.out.println(projects);
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = projectService.projectUpdate(projects);
			sb.append("管理员账户   ");
			sb.append(projects.getHandle_name());
			if (code == 0) {
				sb.append(" 修改失败");
			} else if (code == 1) {
				sb.append(" 修改成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(projects.getHandle_name());
			safeLog.setHandle_id(projects.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
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
	 * @描述 项目删除
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectDelete")
	@ResponseBody
	public Map<String, Object> projectDelete(@RequestBody Projects projects) {
		System.out.println(projects);
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = projectService.projectDelete(projects);
			sb.append("管理员账户   ");
			sb.append(projects.getHandle_name());
			if (code == 0) {
				sb.append(" 删除失败");
			} else if (code == 1) {
				sb.append(" 删除成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(projects.getHandle_name());
			safeLog.setHandle_id(projects.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
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
	public Map<String, Object> projectDesignAdd(@RequestBody List<ProjectDesign> projectDesigns) {
		System.out.println(projectDesigns);
		Map<String, Object> result = new HashMap<String, Object>();
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
	public Map<String, Object> projectDesignUodate(@RequestBody List<ProjectDesign> projectDesigns) {
		System.out.println(projectDesigns);
		Map<String, Object> result = new HashMap<String, Object>();
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
	public Map<String, Object> projectDesignDelete(@RequestBody ProjectDesign projectDesign) {
		Map<String, Object> result = new HashMap<String, Object>();
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

	/**
	 * @ 查询项目条数
	 * 
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectCount")
	public Map<String, Object> projectCount(@RequestBody Projects projects) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer count = projectService.projectCount(projects);
			result.put("count", count);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
		}
		return result;
	}

	/**
	 * @ 项目批量删除
	 * 
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectDeleteAll")
	public Map<String, Object> projectDeleteAll(@RequestBody List<Projects> projectsList) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			for (int i = 0; i < projectsList.size(); i++) {
				StringBuffer sb = new StringBuffer();
				Integer code = projectService.projectDelete(projectsList.get(i));
				sb.append(projectsList.get(i).getHandle_name());// 操作人账户
				sb.append("	删除项目    ");
				sb.append(projectsList.get(i).getTitle());
				if (code == 0) {
					sb.append("	失败");
				} else if (code == 1) {
					sb.append("	成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(projectsList.get(i).getHandle_name());
				safeLog.setHandle_id(projectsList.get(i).getHandle_id());
				safeLog.setHandle(sb.toString());
				safeLog.setHandle_date(new Date());
				safeLogService.safeLogAdd(safeLog);
				result.put("code", code);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
		}
		return result;
	}
}
