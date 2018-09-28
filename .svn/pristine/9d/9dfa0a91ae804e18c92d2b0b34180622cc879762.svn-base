package com.hotelsystem.action.manager.suppermanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.HotelOverTimeBean;
import com.hotelsystem.service.manager.suppermanager.IOverTimeService;

@Controller
public class OverTimeAction {
	@Autowired
    private IOverTimeService oservice;
    /**
     * 查询超时收费规则
     * @author Ren Qiang
	 * @Date 2018/8/9 上午11:47
     * @return 返回酒店超时收费规则
     */
	@RequestMapping(value="/findHotelOverTimeRule.action")
	public @ResponseBody HotelOverTimeBean findHotelOverTimeRule(HttpServletRequest req){		
		HotelOverTimeBean bean=oservice.findHotelOverTimeRule();
		return bean;
	}
	/**
     * 查询超时收费规则
     * @author Ren Qiang
	 * @Date 2018/8/9 上午11:52
	 * @param newOverHalfDayStartTime 新的规定退房时间
     * @param newOverAllDayStartTime 新的超时一天的时间
     * @return 返回修改结果
     */
	@RequestMapping(value="/updateOverTimeRule.action")
	public @ResponseBody String updateOverTimeRule(String newOverHalfDayStartTime,String newOverAllDayStartTime){
		newOverHalfDayStartTime=newOverHalfDayStartTime+":00";
		newOverAllDayStartTime=newOverAllDayStartTime+":00";
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date htime=null;	
		Date atime=null;
		try {
			htime=df.parse(newOverHalfDayStartTime);
			atime=df.parse(newOverAllDayStartTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result=oservice.updateOverTimeRule(htime, atime);
		return result;
	}

}
