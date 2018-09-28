package com.hotelsystem.service.manager.search;

import java.util.Date;

import com.github.pagehelper.PageInfo;

public interface ISerialDisplayService {
	PageInfo findAll(int pageNum);
	PageInfo findSerialByTime(int pageNum,Date startDate,Date endDate);
}
