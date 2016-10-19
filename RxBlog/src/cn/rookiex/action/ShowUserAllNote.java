package cn.rookiex.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;
import cn.rookiex.service.ArticleService;
import cn.rookiex.service.CritiqueService;
import cn.rookiex.service.NoteService;

public class ShowUserAllNote extends ActionSupport{
	// 业务逻辑组件属性
	private NoteService noteService;
	// id属性
	private int id;
	//设置当前页
	private int currentPage;

	public NoteService getNoteService() {
		return noteService;
	}
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		/* 将文章设置到request范围
		// 按ID查询文章
		Note note = noteService.showNote();
		// 获得当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);

		// 将更新的Article保存到数据表中
		noteService.addNote(note);*/
		
		
		//显示评论
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(7);
		
		Result result = noteService.showNoteByPage(page);
		
		request.setAttribute("page", result.getPage());
		request.setAttribute("note", result.getList());
		return this.SUCCESS;
	}
}
