package cn.rookiex.action;

import cn.rookiex.po.User;
import cn.rookiex.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	private String username;
	private String password;
	private String repassword;
	private String nickname;
	private String question;
	private String answer;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public String execute() throws Exception {
		//��װһ��user����
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setQuestion(question);
		user.setAnswer(answer);
		HttpServletRequest rqst = ServletActionContext.getRequest();
		
		if(userService.registerUser(user)) {
			rqst.setAttribute("url", "login.jsp");
			rqst.setAttribute("ifo", "ע��ɹ�");
			return SUCCESS;
		}else {
			rqst.setAttribute("url", "register.jsp");
			rqst.setAttribute("ifo", "�û������ڣ�3�����תע��ҳ��");
			return ERROR;
		}
		
	}

}
