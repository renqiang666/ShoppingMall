package com.hotelsystem.service.manager.suppermanager;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.ManagerLoginBean;

/**
 * @ClassNmae IManagerLoginService
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IManagerLoginService {
	//添加管理员
	public String addManager(String name,String pwd);
	//删除管理员
	public String delManager(int id);
	//查看全部管理员及工作日志
	public List<ManagerLoginBean> allManagerLogin();
	//通过name查询管理员
	public ManagerLoginBean findNameByManager(String name);
	//通过id查询管理员
	public PageInfo findIdByManager(int id, int current);
	//登录
	public String loginManager(String name,String pwd);
	//查看全部管理员
	public PageInfo allManager(int current);
	//查看当前用户权限
	public int managerIdentity(String uname);
	
}
