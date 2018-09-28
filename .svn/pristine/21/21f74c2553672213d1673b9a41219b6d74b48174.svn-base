package com.hotelsystem.service.manager.suppermanager;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.MenmbersBean;

/**
 * @ClassNmae IMenmbersService
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IMenmbersService {
	//添加会员
	public String addMenmbers(String id,String name);
	//删除会员
	public String delMenmbers(String id);
	//根据消费金额自动提升管理员等级
	public String autoUpgrade(double consume, String id);
	//查看所有会员(分页)
	public PageInfo checkAllMenmbers(int current);
	//查看所有会员(未分页)
	public List<MenmbersBean> checkAllMenmbers();
	//根据id查看会员
	public MenmbersBean checkIdByMenmbers(String id);
	//根据名字查找
	List<MenmbersBean> findMenmbersByName(String name);
}
