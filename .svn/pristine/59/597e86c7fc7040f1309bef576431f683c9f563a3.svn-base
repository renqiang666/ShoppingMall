package com.hotelsystem.dao;

import java.util.List;

import com.hotelsystem.bean.ManagerLoginBean;

/**
 * @ClassNmae IManagerLoginDao
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IManagerLoginDao {
	//添加
	public int addManagerLogin(ManagerLoginBean bean);
	//删除
	public int delManagerLogin(int id);
	//查询全部管理员即工作日志
	public List<ManagerLoginBean> findAllManagerLogin();
	//查询全部管理员
	public List<ManagerLoginBean> findAllManager();
	//根据名字查询管理员工作日志
	public ManagerLoginBean findNameByManagerLogin(String name);
	//根据名字查询密码
	public String login(String name);
	//根据名字查询管理员
	public ManagerLoginBean findNameByManager(String name);
	//根据id查询管理员
	public List<ManagerLoginBean> findIdByManagerLogin(int id);
	//查询管理员权限
	public int findIdentity(String name);
}
