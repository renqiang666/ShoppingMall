package com.hotelsystem.service.manager.suppermanager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.dao.IRoomInfoDao;
import com.hotelsystem.service.manager.suppermanager.IRoomInfoService;
@Service
public class RoomInfoServiceImpl implements IRoomInfoService {
	@Autowired
	IRoomInfoDao dao;

	@Override
	public String insertRoom(RoomInfoBean bean) {
        if(bean.getId()==0||bean.getFloor()==0||bean.getRoomState().getId()==0||bean.getRoomType().getId()==0){
			return "数据不合法，不能有空值！";
		}
		if(dao.findRoomInfoById(bean.getId())!=null){
			return "已有该房间，不能添加！";
		}
		//定义楼层的位数
		int floorLength=String.valueOf(bean.getFloor()).length();
		//截取与楼层位数一样的房间号前floorLength位
		String roomFloor=String.valueOf(bean.getId()).substring(0, floorLength);
		if(!roomFloor.equals(String.valueOf(bean.getFloor()))){
			return "房间ID与楼层不符，不能添加！";
		}
		int n=dao.insertRoom(bean);
		if(n>0){
			return "添加成功！";
		}
		return "添加失败！";
	}

	@Override
	public String deleteRoomInfoById(int roomId) {
		int n=dao.deleteRoomInfoById(roomId);
		if(n>0){
			return "删除成功！";
		}
		return "删除失败！";
	}

	@Override
	public String updateRoomStateById(int roomId, int aimStateId) {
		int n=dao.updateRoomStateById(roomId, aimStateId);
		if(n>0){
			return "更新成功！";
		}
		return "更新失败！";
	}

	@Override
	public String findRoomInfoById(int roomId) {
		if(dao.findRoomInfoById(roomId)!=null){
			return "已有该房间";
		}
		return "无该房间";
	}
}
