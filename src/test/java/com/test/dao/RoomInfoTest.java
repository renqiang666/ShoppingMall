package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.bean.RoomStateBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.dao.IHotelOverTimeDao;
import com.hotelsystem.dao.IRoomInfoDao;
import com.test.util.MybatisUtil;

public class RoomInfoTest {

	//修改某具体房间状态
	@Test
	public void test1(){
		// 通过测试包里的工具包产生一个sqlsession对象
		SqlSession session = MybatisUtil.getSqlSession(true);
		try {
			// 通过session调用持久化方法
			IRoomInfoDao dao=session.getMapper(IRoomInfoDao.class);
			System.out.println(dao.updateRoomStateById(1001, 2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//查询所有房间信息，并按楼层分类
		@Test
		public void test2(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomInfoDao dao=session.getMapper(IRoomInfoDao.class);
				System.out.println(dao.findAllRoomInfo());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//查询特定房间类型的可预定数量
		@Test
		public void test3(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomInfoDao dao=session.getMapper(IRoomInfoDao.class);
				System.out.println(dao.findAllRoomInfoCountByType(1));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//删除特定房间ID删除房间信息
		@Test
		public void test4(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomInfoDao dao=session.getMapper(IRoomInfoDao.class);
				System.out.println(dao.deleteRoomInfoById(6006));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//添加房间
		@Test
		public void test5(){
			// 通过测试包里的工具包产生一个sqlsession对象
			SqlSession session = MybatisUtil.getSqlSession(true);
			try {
				// 通过session调用持久化方法
				IRoomInfoDao dao=session.getMapper(IRoomInfoDao.class);
				RoomStateBean sbean=new RoomStateBean();
				sbean.setId(1);
				RoomTypeBean tbean=new RoomTypeBean();
				tbean.setId(1);
				RoomInfoBean bean=new RoomInfoBean();
				bean.setId(6006);
				bean.setFloor(6);
				bean.setRoomState(sbean);
				bean.setRoomType(tbean);
				System.out.println(dao.insertRoom(bean));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
}
