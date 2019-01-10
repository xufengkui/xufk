package com.common.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import static com.common.utils.Collections.newHashMap;

/**
 * View层转换工具
 */
public final class ViewUtil {

	private ViewUtil() {
	}

	/**
	 * 转换通过request.getParameterMap()方法获取的Map
	 * 
	 * @param parameterMap
	 *            通过request.getParameterMap()方法获取的Map
	 * @return 转换后的Map
	 */
	public static Map<String, String> convertParameterMAP(Map<String, String[]> parameterMap) {
		Map<String, String> returnMap = newHashMap();
		Iterator<Entry<String, String[]>> it = parameterMap.entrySet().iterator();
		String value = "";
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			value = "";
			if (entry.getValue().length > 1) {
				for (String i : entry.getValue()) {
					value += i + ",";
				}
			} else {
				value = entry.getValue()[0] + ",";
			}
			value = value.substring(0, value.length() - 1);

			returnMap.put(entry.getKey(), value);
		}
		return returnMap;
	}

}