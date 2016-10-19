package cn.rookiex.service;

import cn.rookiex.dao.BlogInfoDAO;
import cn.rookiex.po.BlogInfo;

public class BlogInfoServiceImpl implements BlogInfoService {
	private BlogInfoDAO blogInfoDAO;
	public BlogInfoDAO getBlogInfoDAO() {
		return blogInfoDAO;
	}

	public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO) {
		this.blogInfoDAO = blogInfoDAO;
	}

	
	public BlogInfo getBlogInfo(String username) {
		return blogInfoDAO.get(username);
	}

	public void setBlogInfo(BlogInfo blogInfo) {
		//通过调用DAO组件来完成
		blogInfoDAO.save(blogInfo);
	}

}
