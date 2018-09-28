package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.dao.IRoomTypeDao;
import com.test.util.MybatisUtil;

public class RoomTypeTest {

	//删除房间类型
	@Test
	public void test1(){
		// 通过测试包里的工具包产生一个sqlsession对象
		SqlSession session = MybatisUtil.getSqlSession(true);
		try {
			// 通过session调用持久化方法
			IRoomTypeDao dao=session.getMapper(IRoomTypeDao.class);
			System.out.println(dao.deleteRoomType(1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//查询所有房间类型
		@Test
		public void test2(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomTypeDao dao=session.getMapper(IRoomTypeDao.class);
				System.out.println(dao.findRoomType());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//查询所有房间类型
		@Test
		public void test3(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomTypeDao dao=session.getMapper(IRoomTypeDao.class);
				RoomTypeBean bean=new RoomTypeBean();
				bean.setArea(40);
				System.out.println(dao.updateRoomTypeById(1, bean));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//根据房间类型名查对应ID
		@Test
		public void test4(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomTypeDao dao=session.getMapper(IRoomTypeDao.class);
				RoomTypeBean bean=new RoomTypeBean();
				bean.setArea(40);
				System.out.println(dao.findRoomTypeIdByTypeName("单人间"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//根据房间类型名查对应ID
		@Test
		public void test5(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomTypeDao dao=session.getMapper(IRoomTypeDao.class);
				System.out.println(dao.findRoomTypeById(1));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
}
