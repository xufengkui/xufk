package com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,
		DisposableBean {
	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory
			.getLogger(SpringContextHolder.class);

	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	public static void clearHolder() {
		applicationContext = null;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		if (applicationContext != null) {
			logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
					+ applicationContext);
		}

		SpringContextHolder.applicationContext = applicationContext;
	}

	public void destroy() throws Exception {
		clearHolder();
	}

	private static void assertContextInjected() {
		if (applicationContext == null) {
			logger.error("applicaitonContext属性未注入, 请在WEB-INF/spring/spring-context.xml中定义SpringContextHolder.");
//			throw new RuntimeException(
//					"applicaitonContext属性未注入, 请在WEB-INF/spring/spring-context.xml中定义SpringContextHolder.");
		}
	}
}