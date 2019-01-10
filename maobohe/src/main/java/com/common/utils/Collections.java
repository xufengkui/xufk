package com.common.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 集合类公共方法
 */
public final class Collections {

	private Collections() {
	}

	/**
	 * HashMap静态工场方法，通过类型推导，简化创建实例
	 */
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * ArrayList静态工场方法，通过类型推导，简化创建实例
	 */
	public static <E> ArrayList<E> newArrayList() {
		return new ArrayList<E>();
	}
}