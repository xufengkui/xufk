package com.maobohe.yhdl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maobohe.yhdl.dao.YhdlMapper;
import com.maobohe.yhdl.service.IYhdlService;

@Service("yhdlService")
public class YhdlServiceImp implements IYhdlService {
	@Autowired
	private YhdlMapper yhdlMapper;
	
	/**
	 * 根据身份查询菜单
	 * @author xufk
	 */
	@Override
	public List<Map<String, Object>> getMenuByYhsf(){
		
		// 调用
		List<Map<String, Object>> menulist = yhdlMapper.getMenuByYhsf();
		return menulist;
	}
	
}
