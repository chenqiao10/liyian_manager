package com.yijie.manager.client.model;

public class ScoreRule {
	private Integer id;
    private String uuid;
    //最大预算
    private double  max_budget;
    //最小预算
    private double   min_budget;
    //积分预算
    private Integer score_budget;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public double getMax_budget() {
		return max_budget;
	}
	public void setMax_budget(double max_budget) {
		this.max_budget = max_budget;
	}
	public double getMin_budget() {
		return min_budget;
	}
	public void setMin_budget(double min_budget) {
		this.min_budget = min_budget;
	}
	public Integer getScore_budget() {
		return score_budget;
	}
	public void setScore_budget(Integer score_budget) {
		this.score_budget = score_budget;
	}
	@Override
	public String toString() {
		return "ScoreRule [id=" + id + ", uuid=" + uuid + ", max_budget=" + max_budget + ", min_budget=" + min_budget
				+ ", score_budget=" + score_budget + "]";
	}
	public ScoreRule(Integer id, String uuid, double max_budget, double min_budget, Integer score_budget) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.max_budget = max_budget;
		this.min_budget = min_budget;
		this.score_budget = score_budget;
	}
	public ScoreRule() {
		super();
	}
     
}
