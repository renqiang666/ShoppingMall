package com.hotelsystem.service.manager.suppermanager;

import java.util.List;

import com.hotelsystem.bean.LevelDiscountBean;

/**
 * @ClassNmae IClassService
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */

public interface ILevelDiscountService {
	//修改折扣，
	public String updateDiscount(int cid,double discount,double consume);
	//添加会员等级
	public String addDiscount(LevelDiscountBean bean);
	//删除会员等级
	public String delDiscount(int id);
	//查看所有会员等级
	public List<LevelDiscountBean> checkAllDiscount();
	//根据id查看所有会员等级
	public LevelDiscountBean checkIdByDiscount(int id);
 }
