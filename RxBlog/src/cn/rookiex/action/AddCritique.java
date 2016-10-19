package cn.rookiex.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.rookiex.po.Critique;
import cn.rookiex.service.CritiqueService;
import cn.rookiex.service.UserService;

public class AddCritique extends ActionSupport {

	private CritiqueService critiqueService;
	private int id;
	private String content;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CritiqueService getCritiqueService() {
		return critiqueService;
	}

	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		
		String username = (String) session.get("username");
		String nickname;
		nickname = this.userService.getNicknameByUser(username);
		if(username == null || "".equals(username)) {
			String IP = request.getRemoteAddr();
			username = "游客"+IP;
			nickname = username;
		}
		if(nickname == null || "".equals(nickname)) {
			nickname = username;
		}
		Critique critique = new Critique();
		critique.setAId(id);
		critique.setContent(content);
		critique.setUsername(username);
		critique.setNickname(nickname);
		// 保存评论
		this.critiqueService.addCritique(critique);

		return this.SUCCESS;
	}

}
