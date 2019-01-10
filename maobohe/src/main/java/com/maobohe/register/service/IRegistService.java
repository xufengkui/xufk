package com.maobohe.register.service;

import java.util.Map;
/**
 * @author xufk
 */
public interface IRegistService {
	/**
	 * 手机号注册
	 */
	void insertUserInfo(Map<String, Object> paramMap);
	/**
	 * 获取瞄号
	 */
	Map<String, Object> getMh(Map<String, Object> paramMap);
	/**
	 * 插入操作记录
	 */
	void insertCzjl(Map<String, Object> paramMap);
	/**
	 * 插入瞄号
	 */
	void insertMh(Map<String, Object> czjlMap);
	/**
	 * 判断是否注册
	 */
	Map<String, Object> getSfzc(Map<String, Object> paramMap);
}
