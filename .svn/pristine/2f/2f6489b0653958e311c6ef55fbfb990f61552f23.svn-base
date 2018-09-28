package com.hotelsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *@ClassName DateCalculation
 *@Description TODO:日期计算
 *@Author Li Gen
 *@Date 2018年8月10日 上午10:43:11
 *@Version 1.0
 **/
public class DateCalculation {
	//计算两个日期之间的天数
	public static int  differenceValue(Date date1,Date date2){
		
		int days = (int)((date1.getTime() - date2.getTime())/86400000);
		
		return days;
	}
	//计算几天过后的日期
	public static Date getNewDate(Date date,int day) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 12:00:00");
		Calendar cal = Calendar.getInstance();
		long addMill = date.getTime() + day * 24 * 3600 * 1000;
		cal.setTimeInMillis(addMill);
		String dat = sdf.format(cal.getTime());
		Date da = sdf.parse(dat);
		return da;	
	}
}
