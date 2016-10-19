package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.po.User;

public interface UserDAO {
	//添加
	public void add(User user);
	//删除
	public void delete(User user);
	//修改
	public void update(User user);
	//查询所有用户
	public List queryAll();
	//按id查询
	public User queryByUsername(String username);
	public String getNicknameByUser(String username);
}
