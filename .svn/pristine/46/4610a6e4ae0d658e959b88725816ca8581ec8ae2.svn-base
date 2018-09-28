package com.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelsystem.dao.IManagerLoginDao;
import com.hotelsystem.service.manager.suppermanager.IManagerLoginService;

public class ManagerLoginTest {

	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//获取bean
		IManagerLoginDao dao=context.getBean("IManagerLoginDao",IManagerLoginDao.class);
		IManagerLoginService service=context.getBean(IManagerLoginService.class);
		String name="";
		String pwd="";
		
		System.out.println(service.loginManager(name, pwd));
	}
}
