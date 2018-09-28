package com.hotelsystem.service.manager.suppermanager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.dao.IRoomTypeDao;
import com.hotelsystem.service.manager.suppermanager.IRoomTypeService;
@Service
public class RoomTypeServiceImpl implements IRoomTypeService {
	@Autowired
	IRoomTypeDao dao;
	
	@Resource(name="roomType")
	String[] roomType;
	
	@Resource(name="roomState")
	String[] roomState;
	
	@Override
	public List<RoomTypeBean> findRoomType() {
		List<RoomTypeBean> list=dao.findRoomType();
		return list;
	}
	@Override
	public Map<String, Integer> findAllRoomTypeDetailInfo() {
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<roomType.length;i++){
			for(int j=0;j<roomState.length;j++){
				map.put(roomType[i]+roomState[j], dao.findRoomTypeDetailInfo(roomType[i], roomState[j]));
			}
		}	
		return map;
	}

}
