package com.hotelsystem.service.user;

import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CommentBean;
import com.hotelsystem.bean.ManagerLoginBean;
import com.hotelsystem.bean.UserLoginBean;

/**
 * @ClassNmae IClassService
 * @author ZhangJiaLin
 * @Descrption TODO
 * @Date 2018/8/4
 * @version 1.0
 */
public interface ICommentService {
	// 查看所有评论
	public PageInfo<CommentBean> getAllComment(int page);
	// 查看是否可以评论
	public int isComment(String account);
	// 添加一条评论
	public String appendComment(UserLoginBean userLogin,CommentBean comment);
	// 管理员删除评论，需要去找到那个评论，然后再去删掉
	public String clearComment(ManagerLoginBean managerLoign,CommentBean comment);
}
