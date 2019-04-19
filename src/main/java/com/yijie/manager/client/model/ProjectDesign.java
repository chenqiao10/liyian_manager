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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getproject_uuid() {
		return project_uuid;
	}

	public void setproject_uuid(String project_uuid) {
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

	@Override
	public String toString() {
		return "ProjectDesign [id=" + id + ", project_uuid=" + project_uuid + ", filename=" + filename + ", design="
				+ design + "]";
	}

	public ProjectDesign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectDesign(Integer id, String project_uuid, String filename, String design) {
		super();
		this.id = id;
		this.project_uuid = project_uuid;
		this.filename = filename;
		this.design = design;
	}

}
