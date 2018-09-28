package com.hotelsystem.action.manager.suppermanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.LevelDiscountBean;
import com.hotelsystem.service.manager.suppermanager.ILevelDiscountService;

@Controller
public class LevelDiscountAction {
@Autowired	
private ILevelDiscountService service;
@RequestMapping(value="/showLevelDiscountAction.action")
public @ResponseBody List<LevelDiscountBean> showLevelDiscountAction(){
	List<LevelDiscountBean> list=service.checkAllDiscount();
	return list;
}
@RequestMapping(value="/upLevelDiscountAction.action")
public @ResponseBody String upLevelDiscountAction(@RequestParam Integer cid, Double cdiscount, Double cconsnume){
	String result=service.updateDiscount(cid, cdiscount, cconsnume);
	return result;
}
}
