package com.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.dao.ILevelDiscountDao;
import com.hotelsystem.service.manager.suppermanager.impl.ILevelDiscountServiceImpl;

public class LevelDiscountTest {
	@Test
	//娴嬭瘯ILevelDiscountServiceImpl
	public void test(){
		//鑾峰彇Sping閰嶇疆鏂囦欢
		ILevelDiscountServiceImpl service= new ILevelDiscountServiceImpl();
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//鑾峰彇bean
		ILevelDiscountDao dao=context.getBean("ILevelDiscountDao",ILevelDiscountDao.class);
		//娉ㄥ叆宸ュ巶
		service.setDao(dao);
		LevelDiscountBean bean=new LevelDiscountBean();
		bean.setClassId(3);		
		bean.setClassDiscount(0.8);
		bean.setClassConsume(600);
		System.out.println(bean);
/*		System.out.println(service.updateDiscount(bean));*/
	
	}
	@Test
	//娴嬭瘯checkIdByDiscount
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//鑾峰彇bean
		ILevelDiscountDao dao=context.getBean("ILevelDiscountDao",ILevelDiscountDao.class);
		
		System.out.println(dao.checkIdByLevelDiscount(1));
	}
	@Test
	public void test3(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//鑾峰彇bean
		ILevelDiscountDao dao=context.getBean("ILevelDiscountDao",ILevelDiscountDao.class);
		ILevelDiscountServiceImpl service= new ILevelDiscountServiceImpl();
		service.setDao(dao);
		LevelDiscountBean bean=new LevelDiscountBean();
		
		bean.setClassName("鑷冲皧vvip");
		bean.setClassDiscount(0.5);
		bean.setClassConsume(50000);
		System.out.println(service.addDiscount(bean));
	}
}
