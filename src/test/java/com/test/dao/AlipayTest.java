package com.test.dao;

import org.junit.Test;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AlipayTest
 * @Description TODO
 * @Author Wu Yimin
 * @Date 2018/8/6 上午10:33
 * @Version 1.0
 **/

public class AlipayTest {
    @Autowired
    private Sid sid;
    @Test
    public void OrderId(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    }
}
