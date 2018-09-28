package com.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelsystem.bean.GuestBean;
import com.hotelsystem.dao.IGuestDao;
public class GuestDaoTest {
	
	
	
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		IGuestDao dao = (IGuestDao) ac.getBean("IGuestDao");
		
	/*	GuestBean bean = dao.findGuestById(1);
		System.out.println(bean);*/
	}
	
}
