package com.yijie.manager.client.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.utils.POIWriteSoftLog;

/**
 * 安全日志模块
 * 
 * @author sunzhu
 *
 */

@RestController
@RequestMapping("/admin")
public class SafeLogController {

	@Autowired
	private SafeLogService safeLogService;

	/**
	 * 安全日志查询
	 * 
	 * @param safeLog
	 * @return
	 */
	@RequestMapping("/safeLogTable")
	public Map<String, Object> safeLogTable(@RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<SafeLog> safeLoglist = safeLogService.safeLogTable(safeLog);
			result.put("safeLoglist", safeLoglist);
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
	 * 安全日志添加
	 * 
	 * @param safeLog
	 * @return
	 */
	@RequestMapping("/safeLogAdd")
	public Map<String, Object> safeLogAdd(@RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = safeLogService.safeLogAdd(safeLog);
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
	 * 安全日志信息删除
	 * 
	 * @param safeLog
	 * @return
	 */
	@RequestMapping("/safeLogDelete")
	public Map<String, Object> safeLogDelete(@RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = safeLogService.safeLogDelete(safeLog);
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
	 * 安全日志信息修改
	 * 
	 * @param safeLog
	 * @return
	 */
	@RequestMapping("/safeLogUpdate")
	public Map<String, Object> safeLogUpdate(@RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = safeLogService.safeLogUpdate(safeLog);
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
	 * 安全日志信息条数
	 * 
	 * @param safeLog
	 * @return
	 */
	@RequestMapping("/safeLogCount")
	public Map<String, Object> safeLogCount(@RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer count = safeLogService.logCount(safeLog);
			result.put("count", count);
			result.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
		}
		return result;
	}

	/**
	 * 安全日志导出
	 * 
	 * @param safeLog
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping("/safeLogOut")
	public Map<String, Object> safeLogOut(HttpServletResponse response, @RequestBody SafeLog safeLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List safeLoglist = safeLogService.safeLogTable(safeLog);
			// 生成Excel文件
			HSSFWorkbook writeExcal = POIWriteSoftLog.writeExcal("安全日志", safeLoglist,
					new String[] { "操作人姓名", "操作人id", "具体操作", "操作时间" });
			// 获取输出流
			OutputStream os = response.getOutputStream();
			// 重置输出流
			response.reset();
			// 设定输出文件头
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String("未命名".getBytes("GB2312"), "8859_1") + ".xls");
			// 定义输出类型
			response.setContentType("application/msexcel");
			writeExcal.write(os);
			os.close();
			result.put("msg", "导出完成");
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

}
