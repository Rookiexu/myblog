package cn.rookiex.action;

import cn.rookiex.po.User;
import cn.rookiex.service.UserService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private String username;
	private String password;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		HttpServletRequest rqst = ServletActionContext.getRequest();
		if(userService.loginUser(user)) {
			rqst.setAttribute("url", "user/getbloginfo.action");
			rqst.setAttribute("ifo", "登陆成功");
			//HttpSession session = rqst.getSession();
			//session.setAttribute("username", username);
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);	 
			return SUCCESS;
		} else {
			rqst.setAttribute("url", "login.jsp");
			rqst.setAttribute("ifo", "用户名或账号错误");
			return ERROR;
		}
	}

}
