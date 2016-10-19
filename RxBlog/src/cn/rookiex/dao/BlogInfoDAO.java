package cn.rookiex.dao;

import cn.rookiex.po.BlogInfo;

public interface BlogInfoDAO {
	//shezhihexinghuaneirong
	public void save(BlogInfo info);
	public BlogInfo get(String username);
}
