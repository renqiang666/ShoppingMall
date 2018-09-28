package com.hotelsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotelsystem.bean.RoomTypeBean;

/**
 * 房间类型Dao
 * @ClassName IRoomTypeDao
 * @Description XXX
 * @author Ren Qiang
 * @Date 2018/8/4 上午10:27
 * @version 1.0
 */
public interface IRoomTypeDao {
	/**
	 * 根据房间类型id对其进行更新，返回受影响行数
	 * @MethodName updateRoomTypeById
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:27
	 * @version 1.0
	 * @param typeId 类型ID
	 * @param bean 房间类型Bean
	 * @return 返回影响行数
	 */
	public int updateRoomTypeById(@Param("typeId")int typeId,@Param("bean")RoomTypeBean bean);
	/**
	 * 根据id删除房间类型，返回受影响行数
	 * @MethodName deleteRoomType
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/4 上午10:32
	 * @version 1.0
	 * @param typeId 房间类型ID
	 * @return 返回受影响行数
	 */
    public int deleteRoomType(int typeId);
    
    /**
	 * 查询所有的房间类型
	 * @MethodName deleteRoomType
	 * @Description TODO
	 * @author Zhang　JiaLin
	 * @Date 2018/8/4 下午3:17
	 * @version 1.0
	 * @param 
	 * @return 房间类型集合
	 */
    public List<RoomTypeBean> findRoomType();
    /**
	 * 根据房间类型名查询该类型ID
	 * @MethodName findRoomTypeIdByTypeName
	 * @Description TODO
	 * @author Ren　Qiang
	 * @Date 2018/8/7 下午2:17
	 * @version 1.0
	 * @param typeName房间类型名
	 * @return 该房间类型ID
	 */
    public int findRoomTypeIdByTypeName(String typeName);
    /**
	 * 根据房间类型名查询该类型房间单价
	 * @MethodName findRoomPriceByTypeName
	 * @Description TODO
	 * @author Ren　Qiang
	 * @Date 2018/8/7 下午3:09
	 * @version 1.0
	 * @param typeName房间类型名
	 * @return 该房间类型价格
	 */
    public int findRoomPriceByTypeName(String typeName);
    /**
	 * 根据房间类型ID查询该房间类型信息
	 * @MethodName findRoomTypeById
	 * @Description TODO
	 * @author Ren　Qiang
	 * @Date 2018/8/7 下午5:46
	 * @version 1.0
	 * @param roomTypeId房间类型ID
	 * @return 该房间类型价格
	 */
    public RoomTypeBean findRoomTypeById(int roomTypeId);
    
    /**
	 * 查询所有房间类型的详细信息
	 * @MethodName findRoomTypeDetailInfo
	 * @Description TODO
	 * @author Ren　Qiang
	 * @Date 2018/8/13 晚上23:39
	 * @version 1.0
	 * @param typeName房间类型名字
	 * @param stateName房间状态名字
	 * @return 该房间类型该状态数量
	 */
    public Integer findRoomTypeDetailInfo(@Param("typeName")String typeName,@Param("stateName") String stateName);
}
