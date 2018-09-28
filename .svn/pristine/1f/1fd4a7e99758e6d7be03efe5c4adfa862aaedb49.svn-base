package com.hotelsystem.service.manager.suppermanager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.ManagerLoginBean;
import com.hotelsystem.dao.IManagerLoginDao;
import com.hotelsystem.service.manager.suppermanager.IManagerLoginService;
@Service
public class IManagerLoginServiceImpl implements IManagerLoginService {
	@Autowired
	private IManagerLoginDao dao;
	
	@Override
	public String addManager(String name,String pwd){
		String result="添加失败";
		ManagerLoginBean bean= dao.findNameByManager(name);
		ManagerLoginBean bean1= new ManagerLoginBean();
		if(name==null&&pwd==null){
			return result;
		}
		if(name.equals("")&&pwd.equals("")){
			result="请输入管理员注册信息";
			return result;
		}
		if(bean!=null){
			result="该用户以存在";
			return result;
		}
		bean1.setUserName(name);
		bean1.setUserPwd(pwd);
		int re=dao.addManagerLogin(bean1);
		if(re==1){
			result="添加管理员成功";
			return result;
		}
		
		return result;
	}

	@Override
	public String delManager(int id) {
		String result="删除失败";
		 int re=dao.delManagerLogin(id);
		 if(re==1){
			 result="删除成功";
		 }
		return result;
	}

	@Override
	public List<ManagerLoginBean> allManagerLogin() {
		
		return dao.findAllManagerLogin();
	}
	
	@Override
	public ManagerLoginBean findNameByManager(String name) {
		return dao.findNameByManager(name);
	}
	
	@Override
	public String loginManager(String name,String pwd){
		String result="登录失败";
		if(name==null&&pwd==null){
			return result;
		}
		if(name==""&&pwd==""){
			result="请输管理员信息";
			return result;
		}
		String realpass=dao.login(name);
		if(realpass==null){
			result="账号不存在";
			return result;
		}
		if(realpass.equals(pwd)){
			result="登录成功";
		}
		else{
			result="密码错误";
		}
		return result;
	}

	@Override
	public PageInfo allManager(int current) {
		
		PageHelper.startPage(current,5);
		List<ManagerLoginBean> list=dao.findAllManager();
		PageInfo page = new PageInfo(list);

		return page;
	}

	@Override
	public PageInfo findIdByManager(int id,int current) {
		PageHelper.startPage(current,5);
		List<ManagerLoginBean> list=dao.findIdByManagerLogin(id);
		PageInfo page = new PageInfo(list);
		return  page;
	}

	@Override
	public int managerIdentity(String uname) {
		
		return dao.findIdentity(uname);
	}

}
