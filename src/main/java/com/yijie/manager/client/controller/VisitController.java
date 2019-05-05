package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Visit;
import com.yijie.manager.client.service.VisitService;

@RestController
@RequestMapping("/Visit")
public class VisitController {
	
	@Autowired
	private VisitService visitService;
	
	/**
	 * @访问量列表
	 * @param visit
	 * @return
	 */
	@RequestMapping("/visitTable")
	public Map<String, Object> visitTable(@RequestBody Visit visit){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<Visit> visitlist = visitService.visitTable(visit);
			result.put("visitlist", visitlist);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	/**
	 * @访问记录量添加
	 * @param visit
	 * @return
	 */
	@RequestMapping("/visitAdd")
	public Map<String, Object> visitAdd(@RequestBody Visit visit){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = visitService.visitAdd(visit);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}
	
	/**
	 * @访问记录量修改
	 * @param visit
	 * @return
	 */
	@RequestMapping("/visitUpdate")
	public Map<String, Object> visitUpdate(@RequestBody Visit visit){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = visitService.visitUpdate(visit);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

}
