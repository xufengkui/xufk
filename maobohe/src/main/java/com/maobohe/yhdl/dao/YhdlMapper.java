package com.maobohe.yhdl.dao;

import java.util.List;
import java.util.Map;

public interface YhdlMapper {
	/**
	 * 根据身份查询菜单
	 * @author xufk
	 */
	List<Map<String, Object>> getMenuByYhsf();
}
