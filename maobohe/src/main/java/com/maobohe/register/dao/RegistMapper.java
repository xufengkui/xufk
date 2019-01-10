package com.maobohe.register.dao;

import java.util.Map;
/**
 * @author xufk
 */
public interface RegistMapper {
	/**
	 * 根据身份查询菜单
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
	 * 获取操作信息
	 */
	Map<String, Object> getCzxx(Map<String, Object> paramMap);
	/**
	 * 插入瞄号
	 */
	void insertMh(Map<String, Object> czjlMap);
	/**
	 * 判断是否注册
	 */
	Map<String, Object> getSfzc(Map<String, Object> paramMap);
}
