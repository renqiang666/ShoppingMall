package com.hotelsystem.dao;

import java.util.List;


import com.hotelsystem.bean.CommentBean;

/**
 * 房间评论dao
 * @author 张加林
 *
 */

public interface ICommentDao {
	/**
	 * 得到评论，不涉及到具体的某个人
	 * @param newDiscountBean
	 * @return
	 */
	public List<CommentBean> findAllComment() ;
	/**
	 * 通过具体的某个用户，添加评论，如果没有登陆，不能评论
	 * @param comment
	 * @return
	 */
	public Integer insertComment(CommentBean comment);
	/**
	 * 管理员登陆之后可以删除评论
	 * @param managerLoign
	 * @return
	 */
	public Integer deleteComment(CommentBean comment);
	
}
