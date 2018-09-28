package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hotelsystem.dao.IHotelOverTimeDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.dao.IRoomStateDao;
import com.test.util.MybatisUtil;

public class RoomStateTest {

	//删除房间状态
	@Test
	public void test1(){
		// 通过测试包里的工具包产生一个sqlsession对象
		SqlSession session = MybatisUtil.getSqlSession(true);
		try {
			// 通过session调用持久化方法
			IRoomStateDao dao=session.getMapper(IRoomStateDao.class);
			System.out.println(dao.deleteRoomState(2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
