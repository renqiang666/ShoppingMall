



package com.hotelsystem.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.hotelsystem.bean.ConsumeBean;

/**
 * @ClassName IConsumeDao
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/7 上午11:56
 * @Version 1.0
 **/

public interface IConsumeDao {
    int insert(@Param("consumeBean") ConsumeBean consumeBean);

    int insertSelective(@Param("consumeBean") ConsumeBean consumeBean);

    int insertList(@Param("consumeBeans") List<ConsumeBean> consumeBeans);

    int update(@Param("consumeBean") ConsumeBean consumeBean);

    List<ConsumeBean> findByConId(@Param("conId")String conId);

    int updateConFlagByConId(@Param("updatedConFlag")Integer updatedConFlag,@Param("conId")String conId);

    List<ConsumeBean> find();












}
