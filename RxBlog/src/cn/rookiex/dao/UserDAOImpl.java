package cn.rookiex.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.rookiex.po.Article;
import cn.rookiex.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delete(User user) {
	
		
	}

	@Override
	public void update(User user) {

		
	}

	@Override
	public List<User> queryAll() {
		
		return null;
	}

	@Override
	public User queryByUsername(String username) {
		List<User> list = (List<User>)this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");
		if(list.size() == 0) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}

	@Override
	public String getNicknameByUser(String username) {
		List<User> list = (List<User>)this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");	
		if(list.size() == 0) {
			return username;
		} else {
			String nickname = username;
			User user = ((User)list.get(0));
			if (user.getNickname() != null) {
				nickname = user.getNickname();
			}
			return nickname;
		}
	}

}
