package com.hotelsystem.service.manager.suppermanager.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.hotelsystem.bean.DBbean;
import com.hotelsystem.service.manager.suppermanager.IDBcopyService;

@Service
public class DBcopyServiceImpl implements IDBcopyService {


	@Override
	public String backup(String backupPath, String dbName,DBbean DB){
		for(int i=0;i<backupPath.length();i++){
			if(backupPath.charAt(i)==' '){
				return "备份失败！路径有空格，路径为"+backupPath;
			}
		}
	    File saveFile = new File(backupPath);  
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }
        if(!backupPath.endsWith(File.separator)){  
        	backupPath = backupPath + File.separator;  
        }
        //备份sql文件的位置及名字
        String backupFile = backupPath+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".sql";
        //获取数据库链接，并找到对应需要备份的数据库
        String mysql =" -h"+DB.getServerUrl()+" -u" + DB.getUsername() + " -p"+ DB.getPassword() + " --opt " + dbName + "> "+backupFile ;
        try {
        	//开始备份数据库
        	 Process process=java.lang.Runtime.getRuntime().exec("cmd /c c:\\mysqldump"+mysql);
        	 if(process.waitFor() == 0){//0 表示线程正常终止。  
				    return "已成功备份至"+backupFile;  
				}
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
        return "备份失败！";
	}
}
