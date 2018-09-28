package com.hotelsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.MenmbersBean;

/**
 * @ClassNmae IMenmbersDao
 * @author Weizhengyi
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface IMenmbersDao{
	//添加
	public int addMenmbers(MenmbersBean bean);
	//更新
	public int updateConsume(@Param("bean")double consume,@Param("id")String i);
	//删除
	public int delMenmbers(String id);
	//查看所有会员
	public List<MenmbersBean> checkAllMenmbers();
	//根据id查看会员
	public MenmbersBean checkIdByMenmbers(String id);
	
	List<MenmbersBean> findMenmbersByName(String name);
}
