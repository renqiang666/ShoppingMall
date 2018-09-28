package com.hotelsystem.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotelsystem.bean.CommentBean;
import com.hotelsystem.bean.ManagerLoginBean;
import com.hotelsystem.bean.UserLoginBean;
import com.hotelsystem.dao.ICommentDao;
import com.hotelsystem.dao.ILoginAndRegisterDao;
import com.hotelsystem.service.user.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	private ICommentDao commentDao;
	@Autowired
	private ILoginAndRegisterDao lrDao;
	
	@Override
	public PageInfo<CommentBean> getAllComment(int page) {

		PageHelper.startPage(page, 6);
		List<CommentBean> commentList = commentDao.findAllComment();
		PageInfo<CommentBean> pageCommentList=new PageInfo<CommentBean>(commentList);
		return pageCommentList;
	}

	@Override
	public String appendComment(UserLoginBean userLogin, CommentBean comment) {
		// 添加评论，需要住房之后才能添加评论，而且只能一条一条的添加评论
		// 先查询userLogin有没有，如果有就可以操作，如果没有就说评论失败，先登陆
		// 需要通过userLogin得到是否可以评论的信息，现在未实现
		String result = "评论失败";
		int count = 0;
		if(userLogin == null) {
			result = "请先登陆";
		}else {
			comment.setUserLogin(userLogin);
			count = commentDao.insertComment(comment);
			if(count != 0) {
				result = "评论成功";
				lrDao.closeComment(userLogin.getAccount());
			}
		}	
		return result;
	}

	@Override
	public String clearComment(ManagerLoginBean managerLoign,CommentBean comment) {
		// 管理员删除评论
		// 删除结果
		String result = "删除失败";
		int count = 0;
		if(managerLoign == null) {
			result = "管理员未登陆";
		}else {
			/*SqlSession session = MybatisUtil.getSqlSession(true);
			ICommentDao dao = session.getMapper(ICommentDao.class);*/
			count = commentDao.deleteComment(comment);
			if(count != 0) {
				result = "删除成功";
			}
		}
		return result;
	}

	@Override
	public int isComment(String account) {
		int i=lrDao.userComment(account);
		return i;
	}


}
