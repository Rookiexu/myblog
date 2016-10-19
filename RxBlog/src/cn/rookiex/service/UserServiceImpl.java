package cn.rookiex.service;

import cn.rookiex.dao.UserDAO;
import cn.rookiex.po.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	@Override
	public boolean registerUser(User user) {
		if(userDAO.queryByUsername(user.getUsername()) != null) {
			return false;
		}else {
			userDAO.add(user);
			return true;
		}
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public boolean loginUser(User user) {
		if(userDAO.queryByUsername(user.getUsername()) == null) {
			
			return false;
		}else {
			User queryUser = userDAO.queryByUsername(user.getUsername());
			if(queryUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	@Override
	public String getNicknameByUser(String username) {
		String nickname;
		nickname = userDAO.getNicknameByUser(username);
		return nickname;
	}

}
