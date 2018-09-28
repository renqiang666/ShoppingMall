package com.woniuxy.shopping.listener;

import java.util.Hashtable;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {
	Hashtable<String,HttpSession> map=new Hashtable<String,HttpSession>();
    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	//获取当前事件的属性名和属性值
    			String key=arg0.getName();
    			Object value=arg0.getValue();
    			//判断当前属性是否是account
    			if(key.equals("account")){
    				//获取当前的session
    				HttpSession currentSession=arg0.getSession();
    				//将属性值强转为String类型
    				String account=(String)value;
    				//获取旧session
    				HttpSession oldSession=map.get(account);
    				//判断新旧session是否一致
    				if((oldSession!=null)&&
    						!(oldSession.getId().equals(currentSession.getId()))){
    					//将oldSession里的登录状态删除
    					oldSession.removeAttribute("account");
    				}   				
    				//将新session存放到map里
    				//System.out.println("account为"+account);
    				map.put(account, currentSession);
    			}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
