package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Adcolumn;
import com.yijie.manager.client.service.AdcolumnService;
import com.yijie.manager.client.utils.Uuid;

@RestController
@RequestMapping("/admin")
public class AdcolumnController {
	
	@Autowired
	private AdcolumnService adcolumnService;
	
	/**
	 * 广告轮播列表
	 * 
	 * @param adcolumn
	 * @return
	 */
	@RequestMapping("/adcolumnSelect")
	public Map<String, Object> adcolumnSelect(@RequestBody Adcolumn adcolumn){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Adcolumn> list = adcolumnService.adcolumnSelect(adcolumn);
			map.put("data", list);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "系统出错");
			map.put("code", 0);
		}
		return map;
	}
	
	/**
	 * 广告轮播信息删除
	 * 
	 * @param adcolumn
	 * @return
	 */
	@RequestMapping("/adcolumnDelete")
	public Map<String, Object> adcolumnDelete(@RequestBody Adcolumn adcolumn){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adcolumnService.adcolumnDelete(adcolumn);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 广告轮播信息修改
	 * 
	 * @param adcolumn
	 * @return
	 */
	@RequestMapping("/adcolumnUpdate")
	public Map<String, Object> adcolumnUpdate(@RequestBody Adcolumn adcolumn){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = adcolumnService.adcolumnUpdate(adcolumn);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 广告轮播信息添加
	 * 
	 * @param adcolumn
	 * @return
	 */
	@RequestMapping("/adcolumnInsert")
	public Map<String, Object> adcolumnInsert(@RequestBody Adcolumn adcolumn){
		Map<String, Object> map = new HashMap<String, Object>();
		adcolumn.setUuid(Uuid.getUuid());
		Integer code = adcolumnService.adcolumnInsert(adcolumn);
		map.put("code", code);
		return map;
	}
}
