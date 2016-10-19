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
	// ҵ���߼��������
	private NoteService noteService;
	// id����
	private int id;
	//���õ�ǰҳ
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
		/* ���������õ�request��Χ
		// ��ID��ѯ����
		Note note = noteService.showNote();
		// ��õ�ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);

		// �����µ�Article���浽���ݱ���
		noteService.addNote(note);*/
		
		
		//��ʾ����
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(7);
		
		Result result = noteService.showNoteByPage(page);
		
		request.setAttribute("page", result.getPage());
		request.setAttribute("note", result.getList());
		return this.SUCCESS;
	}
}
