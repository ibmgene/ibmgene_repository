package cn.ibm.com.web.generation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLocator {

	private static ApplicationContext app;

	public static Object getBean(String name) {
		if (app == null) {
			app = new ClassPathXmlApplicationContext("classpath*:conf/spring/*.xml");
		}
		return app.getBean(name);
	}
}
