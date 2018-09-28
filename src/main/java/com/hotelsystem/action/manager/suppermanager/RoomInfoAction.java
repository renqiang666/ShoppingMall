package com.hotelsystem.action.manager.suppermanager;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelsystem.bean.RoomInfoBean;
import com.hotelsystem.bean.RoomStateBean;
import com.hotelsystem.bean.RoomTypeBean;
import com.hotelsystem.service.manager.suppermanager.IOverTimeService;
import com.hotelsystem.service.manager.suppermanager.IRoomInfoService;
import com.hotelsystem.service.manager.suppermanager.IRoomTypeService;


@Controller
public class RoomInfoAction {
	@Autowired
    private IRoomInfoService iservice;
	@Autowired
    private IRoomTypeService tservice;
	@Autowired
    private IOverTimeService oservice;
    /**
     * 添加房间
     * @author Ren Qiang
	 * @Date 2018/8/10 上午12:11
	 * @param bean 新的房间
     * @return 返回添加结果
     */
	@RequestMapping(value="/insertRoom.action")
	public @ResponseBody String insertRoom(Integer id,Integer floor,Integer typeId,Integer stateId){
		RoomInfoBean bean =new RoomInfoBean();
		RoomStateBean sbean=new RoomStateBean();
		RoomTypeBean tbean=new RoomTypeBean();
		bean.setId(id);
		bean.setFloor(floor);
		sbean.setId(stateId);
		tbean.setId(typeId);
		bean.setRoomState(sbean);
		bean.setRoomType(tbean);
		String result=iservice.insertRoom(bean);
		return result;
	}
	/**
     * 删除房间
     * @author Ren Qiang
	 * @Date 2018/8/10 上午12:13
	 * @param roomId 房间ID
     * @return 返回删除结果
     */
	@RequestMapping(value="/deleteRoomInfoById.action")
	public @ResponseBody String deleteRoomInfoById(Integer roomId){
		String result=iservice.deleteRoomInfoById(roomId);
		return result;
	}
	/**
     * 按房间号修改其房间状态
     * @MethodName updateRoomStateById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:12
	 * @version 1.0
     * @param roomId 房间ID
     * @param aimStateId
     * @return 返回修改结果
     */
	@RequestMapping(value="/updateRoomStateById.action")
	public @ResponseBody String updateRoomStateById(Integer roomId,Integer aimStateId){
		String result=iservice.updateRoomStateById(roomId, aimStateId);
		return result;
	}
	/**
     * 查询所有房间类型的详细信息
     * @MethodName findAllRoomTypeDetailInfo
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/14 上午9:00
	 * @version 1.0
     * @return 返回map
     */
	@RequestMapping(value="/findAllRoomTypeDetailInfo.action")
	public @ResponseBody Map<String,Integer> findAllRoomTypeDetailInfo(){
		Map<String,Integer> map=tservice.findAllRoomTypeDetailInfo();
		return map;
	}
	/**
     * 按房间号查询房间
     * @MethodName findRoomByRoomId
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/16 上午12:00
	 * @version 1.0
     * @return 返回查询结果
     */
	@RequestMapping(value="/findRoomByRoomId.action")
	public @ResponseBody String findRoomByRoomId(Integer roomId){
		String result=iservice.findRoomInfoById(roomId);
		return result;
	}

}
