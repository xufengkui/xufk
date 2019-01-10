package com.common.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * 
 * Title: JsonUtil.java
 * Description: json公共处理类
 */
public class JsonUtil {

	private static final Log log = LogFactory.getLog(JsonUtil.class);


	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String map2Json(Map map) {
		JSONObject json = JSONObject.fromObject(map);

		return json == null ? "" : json.toString();
	}

	/**
	 * json转map
	 * @param jsonStr
	 * @return
	 */
	public static Map json2Map(String jsonStr) {
		JSONObject obj = JSONObject.fromObject(jsonStr);
		Map map = new HashMap();
		Iterator it = obj.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = obj.get(key).toString();
			map.put(key, value);
		}

		return map == null ? null : map;
	}


	/**
	 * xml转换成jSON对象
	 * @param xml
	 * @return
	 */
	public static JSONObject xml2JSONObject(String xml) {

		XMLSerializer xmlSerializer = new XMLSerializer();

		JSONObject json = (JSONObject) xmlSerializer.read(xml);

		return json;
	}

	/**
	 * 将对象转换为json字符串
	 * @param object
	 * @return
	 */
	public static String objectToJsonStr(Object object) {
		try {
			ObjectMapper om = new ObjectMapper();
			return om.writeValueAsString(object);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	/**
	 * 将json转换为Object
	 * @param jsonStr
	 * @return
	 */
	public static Object jsonStrToObject(String jsonStr) {
		try {
			ObjectMapper om = new ObjectMapper();
			return om.readValue(jsonStr, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将json字符串转换为map
	 * @param jsonStr
	 * @return
	 */
	public static Map<?, ?> jsonStrToMap(String jsonStr) {
		try {
			ObjectMapper om = new ObjectMapper();
			return om.readValue(jsonStr, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化json字符串
	 * @param jsonStr
	 * @return
	 */
	public static String formatJsonStr(String jsonStr) {
		try {
			ObjectMapper om = new ObjectMapper();
			return om.writerWithDefaultPrettyPrinter().writeValueAsString(jsonStrToMap(jsonStr));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String> ();
		map.put("name", "zhangsan");
		Map<String, String> map1 = new HashMap<String, String> ();
		map1.put("name", "zhangsan1");
		list.add(map);
		list.add(map1);
		System.out.println(objectToJsonStr(list));
	}
}
