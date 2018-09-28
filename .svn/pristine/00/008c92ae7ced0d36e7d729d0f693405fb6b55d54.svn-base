package com.test.dao;


import com.hotelsystem.bean.ConsumeBean;
import com.hotelsystem.bean.HotelDiscountBean;
import com.hotelsystem.dao.IConsumeDao;
import com.hotelsystem.dao.IHotelDiscountDao;
import com.test.util.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName ConsumeDaoTest
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/7 下午3:18
 * @Version 1.0
 **/
public class ConsumeDaoTest {
    @Test
    public void test1(){
        SqlSession session = MybatisUtil.getSqlSession(true);
        try {
            IConsumeDao consumeDao=session.getMapper(IConsumeDao.class);
      /*      ConsumeBean consumeBean=new ConsumeBean("201","101","哈哈",14,11.11,new Date(),1);
            consumeDao.insert(consumeBean);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
