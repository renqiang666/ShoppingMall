package com.hotelsystem.service.manager.suppermanager.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.bean.MenmbersBean;
import com.hotelsystem.dao.ILevelDiscountDao;
import com.hotelsystem.dao.IMenmbersDao;
import com.hotelsystem.service.manager.suppermanager.IMenmbersService;
@Service
public class IMenmbersServiceImpl implements IMenmbersService {
	@Autowired
	private IMenmbersDao dao;
	@Autowired
	private ILevelDiscountDao ldao;

	@Override
	public String addMenmbers(String id,String name) {
		String result="添加会员失败";
		MenmbersBean bean1=dao.checkIdByMenmbers(id);
		if(bean1!=null){
			result="该会员已存在";
			return result;
		}
		if(id.equals(null)&&name.equals(null)){
			return result;
		}
		if(id.equals("")&&name.equals("")){
			result="请输入会员信息";
			return result;
		}
		if(!(id.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$"))){
			result="手机号格式不正确";
			return result;
		}
		MenmbersBean bean=new MenmbersBean();
		LevelDiscountBean lb=ldao.checkIdByLevelDiscount(1);
		bean.setmId(id);
		bean.setmName(name);
		bean.setLb(lb);
		int re=dao.addMenmbers(bean);
		if(re==1){
			result="添加会员成功";
		}
		return result;
	}

	@Override
	public String delMenmbers(String id) {
		String result="删除会员失败";
		int re=dao.delMenmbers(id);
		if(re==1){
			result="删除成功";
		}
		return result;
	}


	@Override
	public String autoUpgrade(double consume,String id) {
		String result="操作失败";
		int re=dao.updateConsume(consume, id);
		if(re==1){
			result="更新成功";
		}
		return result; 
	}

	@Override
	public PageInfo checkAllMenmbers(int current) {
		PageHelper.startPage(current,5);
		List<MenmbersBean> list=dao.checkAllMenmbers();
		PageInfo page = new PageInfo(list);
		return page;
	}

	@Override
	public MenmbersBean checkIdByMenmbers(String id) {
		
		return dao.checkIdByMenmbers(id);
	}

	@Override
	public List<MenmbersBean> checkAllMenmbers() {
		List<MenmbersBean> list=dao.checkAllMenmbers();
		return list;
	}

	@Override
	public List<MenmbersBean> findMenmbersByName(String name) {
		List<MenmbersBean> list = dao.findMenmbersByName(name);
		return list;
	}
}
