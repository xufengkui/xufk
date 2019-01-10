package com.maobohe.register.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maobohe.register.dao.RegistMapper;
import com.maobohe.register.service.IRegistService;

/**
 * @author xufk
 */
@Service("registService")
public class RegistServiceImp implements IRegistService {
	@Autowired
	private RegistMapper registMapper;
	
	/**
	 * 手机号注册
	 */
	@Override
	public void insertUserInfo(Map<String, Object> paramMap){
		
		// 调用
		registMapper.insertUserInfo(paramMap);
	}
	/**
	 * 获取瞄号
	 */
	@Override
	public Map<String, Object> getMh(Map<String, Object> paramMap) {
		
		return registMapper.getMh(paramMap);
	}
	/**
	 * 插入操作记录
	 */
	@Override
	public void insertCzjl(Map<String, Object> paramMap) {
//		Map<String, Object> outMap = new HashMap<String, Object>();
//		outMap = registMapper.getCzxx(paramMap);
//		paramMap.putAll(outMap);
		registMapper.insertCzjl(paramMap);
		
	}
	/**
	 * 插入瞄号
	 */
	@Override
	public void insertMh(Map<String, Object> czjlMap) {
		
		registMapper.insertMh(czjlMap);
		
	}
	/**
	 * 判断是否注册
	 */
	@Override
	public Map<String, Object> getSfzc(Map<String, Object> paramMap) {
		
		return registMapper.getSfzc(paramMap);
	}
	
}
