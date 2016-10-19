package cn.rookiex.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import cn.rookiex.po.Note;
import cn.rookiex.service.NoteService;
import cn.rookiex.service.UserService;

public class AddNote extends ActionSupport{
	private String content;
	private NoteService noteService;
	private UserService userService;
	private String load;

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NoteService getNoteService() {
		return noteService;
	}
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
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
		
		Note note = new Note();
		note.setDate(new Date());
		note.setContent(content);
		note.setUsername(username);
		note.setNickname(nickname);
		
		String e = "e";
		load = this.getLoad();
		// 保存评论
		this.noteService.addNote(note);
		System.out.println(e.equals(load));
		if(e.equals(load)) {
			return this.ERROR;
		} else {
			return this.SUCCESS;
		}
	}
}
