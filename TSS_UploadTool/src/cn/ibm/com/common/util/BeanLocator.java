package cn.ibm.com.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 加载SPRING配置文件工具类
 * @author bibos
 * @date   2011-05-17
 *
 */

public class BeanLocator {

	private static final String CONTEXT_LOCATION = "/applicationContext.xml";

	private static final String[] locations = { CONTEXT_LOCATION};


	private static ApplicationContext app;

	public static Object getBean(String name) {
		if (app == null) {
			app = new ClassPathXmlApplicationContext(locations);
		}
		return app.getBean(name);
	}
}
