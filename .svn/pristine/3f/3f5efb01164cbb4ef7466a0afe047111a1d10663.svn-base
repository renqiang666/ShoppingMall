package com.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.dao.ILevelDiscountDao;
import com.hotelsystem.dao.IMenmbersDao;
import com.hotelsystem.service.manager.suppermanager.impl.IMenmbersServiceImpl;


public class MenubersTest {
	private IMenmbersServiceImpl service=new IMenmbersServiceImpl();
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILevelDiscountDao ldao=context.getBean("ILevelDiscountDao", ILevelDiscountDao.class);
		IMenmbersDao dao=context.getBean("IMenmbersDao", IMenmbersDao.class);
/*		service.setDao(dao);
		service.setLdao(ldao);*/
		
		System.out.println(service.autoUpgrade(5000,"13011111112"));
	}
}
