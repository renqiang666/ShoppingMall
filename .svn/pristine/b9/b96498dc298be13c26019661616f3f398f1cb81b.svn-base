package com.hotelsystem.service.manager.reserve.impl;

import java.util.List;

import javax.annotation.Resource;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelsystem.bean.SerialBean;
import com.hotelsystem.dao.ISerialDao;
import com.hotelsystem.service.manager.reserve.SerialService;

@Service(value="serial2")
public class SerialServiceImpl implements SerialService{

    @Resource
    private ISerialDao serialDao;
    @Autowired
    private Sid sid;

    @Override
    public int insert(SerialBean serialBean){
        String seId=sid.next();
        serialBean.setSeId(seId);
        return serialDao.insert(serialBean);
    }

    @Override
    public int insertSelective(SerialBean serialBean){
        return serialDao.insertSelective(serialBean);
    }

    @Override
    public int insertList(List<SerialBean> serialBeans){
        return serialDao.insertList(serialBeans);
    }

    @Override
    public int update(SerialBean serialBean){
        return serialDao.update(serialBean);
    }
}
