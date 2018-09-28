package com.hotelsystem.service.manager.suppermanager;

import com.hotelsystem.bean.DBbean;

/**
 * 数据库备份Service
 * @author Administrator
 *
 */
public interface IDBcopyService {
	/**
	 * 数据库备份
	 * @MethodName backup
	 * @Description TODO
	 * @author Ren Qiang
	 * @Date 2018/8/16 下午15:26
	 * @version 1.0
	 * @param backupPath为备份路径
	 * @param dbName为备份目标数据库名字
	 * @param DB为数据库Bean，包括url，name,pwd
	 * @return 返回备份文件名
	 */
	String backup(String backupPath, String dbName,DBbean DB);
}
