package com.maobohe.yhdl.service;

import java.util.List;
import java.util.Map;

public interface IYhdlService {
	/**
	 * 根据身份查询菜单
	 * @author xufk
	 */
	List<Map<String, Object>> getMenuByYhsf();
}
