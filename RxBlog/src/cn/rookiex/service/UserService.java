package cn.rookiex.service;

import cn.rookiex.po.User;

public interface UserService {
	//�û�ע��
	public boolean registerUser(User user);

	public boolean loginUser(User user);

	public String getNicknameByUser(String username);
}