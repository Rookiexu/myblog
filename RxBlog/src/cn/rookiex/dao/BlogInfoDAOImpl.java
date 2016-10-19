package cn.rookiex.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.rookiex.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO {

	@Override
	public void save(BlogInfo info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(info);
	}

	@Override
	public BlogInfo get(String username) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username = ?", username);
		if(list.size() == 0) {
			return null;
		} else {
			return (BlogInfo) list.get(0);
		}
	}

}
