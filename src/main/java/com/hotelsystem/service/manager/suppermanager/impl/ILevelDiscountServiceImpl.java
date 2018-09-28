package com.hotelsystem.service.manager.suppermanager.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.dao.ILevelDiscountDao;
import com.hotelsystem.service.manager.suppermanager.ILevelDiscountService;

@Service
public class ILevelDiscountServiceImpl implements ILevelDiscountService {
		@Autowired
	private ILevelDiscountDao dao;

	public void setDao(ILevelDiscountDao dao) {
		this.dao = dao;
	}
	@Override
	public String updateDiscount(int cid,double discount,double consume) {
		String result="更新失败";
		if(discount>0&&discount<1){
			
		
		LevelDiscountBean bean=dao.checkIdByLevelDiscount(cid);
		if(cid==1){
			LevelDiscountBean bean1=dao.checkIdByLevelDiscount(cid+1);
			if(discount<bean1.getClassDiscount()){
				result="修改信息错误！折扣不能高于下一等级";
				return result;
			}
			if(consume>bean1.getClassConsume()){
				result="修改信息错误！最低消费金额不能高于下一等级";
			}
			bean.setClassConsume(consume);
			bean.setClassDiscount(discount);
			int re=dao.updateLevelDiscount(bean);
			if(re==1){
				result="更新成功";
				}
		}
		else{
			LevelDiscountBean bean1=dao.checkIdByLevelDiscount(cid+1);
			LevelDiscountBean bean2=dao.checkIdByLevelDiscount(cid-1);
			if(discount<bean1.getClassDiscount()){
				result="修改信息错误！折扣不能高于下一等级";
				return result;
			}
			//0.9 0.8
			if(discount>bean2.getClassDiscount()){
				result="修改信息错误！折扣不能低于上一等级";
				return result;
			}
			if(consume>bean1.getClassConsume()){
				result="修改信息错误！最低消费金额不能高于下一等级";
				return result;
			}
			if(consume<bean.getClassConsume()){
				result="修改信息错误！最低消费金额不能低于于上一等级";
				return result;
			}
			bean.setClassConsume(consume);
			bean.setClassDiscount(discount);
			int re=dao.updateLevelDiscount(bean);
			if(re==1){
			result="更新成功";
			}
		}
		}
		else{
			result="请输入正确数字";
		}
		return result;
	}

	@Override
	public String addDiscount(LevelDiscountBean bean) {
		String result="添加失败";
		if(bean!=null){
			int cid=bean.getClassId();
			
			double discount=bean.getClassDiscount();
			LevelDiscountBean bean1 =dao.checkIdByLevelDiscount(cid-1);
			if(discount<=0&&discount>1&&discount<bean1.getClassDiscount()){
				result="打折信息错误";
				return result;
			}
			if(bean1.getClassConsume()>bean.getClassConsume()){
				result="最低消费金额错误";
				return result;
			}
			int re=dao.addLevelDiscount(bean);
			if(re==1){
				result="更新成功";
			}
		}else {
			result="请输入";
		}
		
		return result;
	}

	@Override
	public String delDiscount(int id) {
		String result="删除失败";
		int re=dao.delLevelDiscount(id);
		if(re==1){
			result="删除成功";
		}
		return result;
	}

	@Override
	public List<LevelDiscountBean> checkAllDiscount() {
		return dao.checkLevelDiscount();
	}

	@Override
	public LevelDiscountBean checkIdByDiscount(int id) {
		return dao.checkIdByLevelDiscount(id);
	}

}
