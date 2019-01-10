package com.maobohe.yhdl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maobohe.yhdl.service.IYhdlService;

/**
 * @title: 用户登录 交互层实现类
 */
@Controller
@RequestMapping(value = "/yhdl")
public class YhdlController {
	private Log log = LogFactory.getLog(YhdlController.class);
	@Autowired
	private IYhdlService yhdlService;
	
	/**
	 * 根据身份获取菜单
	 */
	@RequestMapping("/getMenuByYhsf")
	@ResponseBody
	public Map<String, Object> getMenuByYhsf(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("================================================");
		// 根据身份查询菜单
		List<Map<String, Object>> menulist = new ArrayList<Map<String, Object>>();
		menulist = yhdlService.getMenuByYhsf();
		System.out.println("==================menulist=============================="+menulist);
		// 输出
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put("menulist", menulist);
		return outMap;
	}
	
}
