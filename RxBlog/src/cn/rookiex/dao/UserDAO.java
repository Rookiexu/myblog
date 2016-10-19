package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.po.User;

public interface UserDAO {
	//���
	public void add(User user);
	//ɾ��
	public void delete(User user);
	//�޸�
	public void update(User user);
	//��ѯ�����û�
	public List queryAll();
	//��id��ѯ
	public User queryByUsername(String username);
	public String getNicknameByUser(String username);
}
