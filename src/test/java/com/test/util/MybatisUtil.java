package com.test.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis工具类
 * @author 张加林
 *
 */
public class MybatisUtil {
	/** 
	 * 获取工厂对象
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		// ��һ�������������ļ������������ļ�����һ����������
		String resource = "daotestconfig.xml";
		InputStream inputStream = null;
		SqlSessionFactory fa = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			fa = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fa;
	}
	
	/**  
	 * 获取SqlSession,这个session不会自动提交事务，用于查询操作
	 * @return
	 */
	public static SqlSession getSqlSession() {
		// ͨ���������󣬲���һ��sqlsession����
		SqlSessionFactory fa = getSqlSessionFactory();
		SqlSession session = null;
		session = fa.openSession();
		return session;
	}
	
	/** 
	 *  获取SqlSession,这个session会自动提交事务，用于插入，更新，删除操作
	 * @return
	 */
	public static SqlSession getSqlSession(boolean boo) {
		// ͨ���������󣬲���һ��sqlsession����
		SqlSessionFactory fa = getSqlSessionFactory();
		SqlSession session = null;
		session = fa.openSession(boo);
		return session;
	}
}
