package com.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotelsystem.dao.IManagerLoginDao;
import com.hotelsystem.dao.IManagerRecordDao;
import com.hotelsystem.service.manager.suppermanager.impl.IManagerRecordServiceImpl;


public class ManageRecord {
	private IManagerRecordServiceImpl service=new IManagerRecordServiceImpl();
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		IManagerLoginDao dao=context.getBean("IManagerLoginDao",IManagerLoginDao.class);//获取bean
		IManagerRecordDao dao1=context.getBean("IManagerRecordDao",IManagerRecordDao.class);
/*		service.setDao(dao1);
		service.setLdao(dao);
		String name="admin1";
		int cid=service.punchIn(name);
		service.punchOut(cid);*/
	}
}
