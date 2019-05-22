package com.yijie.manager.client.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.ProjectDesign;
import com.yijie.manager.client.model.Projects;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.ScoreRecord;
import com.yijie.manager.client.model.User;
import com.yijie.manager.client.service.ProjectService;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.ScoreRecordService;
import com.yijie.manager.client.service.UserHandleService;
import com.yijie.manager.client.utils.Uuid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	@Autowired
	private UserHandleService userHandleService;
	@Autowired
	private ScoreRecordService scoreRecordService;
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
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				result.put("code", 0);
			}
			return result;
	}
	/**
	 * @描述 项目审核Audit/0未通过/1通过
	 * @param projects
	 * @return
	 */
	@RequestMapping("/projectAudit")
	public Map<String, Object> projectAudit(@RequestBody Projects projects) {
		System.out.println(projects+"#############");
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(projects.getId()!=null) {
		ScoreRecord scoreRecord = new ScoreRecord();
		SafeLog log = new SafeLog();
		StringBuffer sb = new StringBuffer();
		sb.append("用户: ");
		sb.append(projects.getPhone());
		sb.append("项目名: ");
		sb.append(projects.getTitle());
		log.setHandle_name(projects.getHandle_name());
		log.setHandle_id(projects.getHandle_id());
		try {
			if (projects.getAudit() == 0) {
				sb.append("项目审核不通过");
			} else if (projects.getAudit() == 1) {
				sb.append("项目审核通过");
			}
			Projects pro = new Projects();
			pro.setId(projects.getId());
			pro.setAudit(projects.getAudit());
			pro.setPrice(projects.getPrice());
			Integer code = projectService.projectUpdate(pro);
			//项目审核通过之后给用户增加积分
			if(code!=0&&projects.getAudit() == 1) {
				User u = new User();
				u.setUuid(projects.getUser_uuid());
				User user = userHandleService.userLogin(u);
				user.setBalance(user.getBalance()+projects.getPrice());
				Integer usercode = userHandleService.userUpdate(user);
				if(usercode != 0) {//添加审核项目通过的积分记录
					String time = sdf.format(new Date());
					scoreRecord.setDate(sdf.parse(time));
					scoreRecord.setType(2);
					scoreRecord.setUser_uuid(projects.getUser_uuid());
					scoreRecord.setScore(projects.getPrice());
					scoreRecordService.scoreRecordAdd(scoreRecord);
				}
			}
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
		}
		return result;
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
	public Map<String, Object> projectDeleteAll(@RequestBody JSONObject json) {
		Map<String, Object> result = new HashMap<String, Object>();
		JSONArray jsonArray = json.getJSONArray("projectList");
		List<Projects> projectList = (List<Projects>) jsonArray.toCollection(jsonArray, Projects.class);
		try {
			for (int i = 0; i < projectList.size(); i++) {
				System.out.println(projectList.get(i));
				StringBuffer sb = new StringBuffer();
				Integer code = projectService.projectDelete(projectList.get(i));
				sb.append(projectList.get(i).getHandle_name());// 操作人账户
				sb.append("	删除项目    ");
				sb.append(projectList.get(i).getTitle());
				if (code == 0) {
					sb.append("	失败");
				} else if (code == 1) {
					sb.append("	成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(projectList.get(i).getHandle_name());
				safeLog.setHandle_id(projectList.get(i).getHandle_id());
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
