package com.yijie.manager.client.model;

/**
 * @描述 项目对应附件
 * @author Lucifer
 *
 */
public class ProjectDesign {

	// 自增ID
	private Integer id;

	// 对应项目UUID
	private String project_uuid;

	// 附件对应文件名
	private String filename;

	// 附件路径
	private String design;

	//操作人名字
	private String handle_name;
	
	//操作人id
	private Integer handle_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProject_uuid() {
		return project_uuid;
	}

	public void setProject_uuid(String project_uuid) {
		this.project_uuid = project_uuid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getHandle_name() {
		return handle_name;
	}

	public void setHandle_name(String handle_name) {
		this.handle_name = handle_name;
	}

	public Integer getHandle_id() {
		return handle_id;
	}

	public void setHandle_id(Integer handle_id) {
		this.handle_id = handle_id;
	}

	@Override
	public String toString() {
		return "ProjectDesign [id=" + id + ", project_uuid=" + project_uuid + ", filename=" + filename + ", design="
				+ design + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public ProjectDesign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectDesign(Integer id, String project_uuid, String filename, String design, String handle_name,
			Integer handle_id) {
		super();
		this.id = id;
		this.project_uuid = project_uuid;
		this.filename = filename;
		this.design = design;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}
	
	
}
