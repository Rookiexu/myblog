package cn.rookiex.service;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;

public interface NoteService {
	//添加留言
	public void addNote(Note note);
	//分页显示
	public Result showNoteByPage(Page page);
	//获得留言总数
	public int getNoteCount();
	//显示文章
	public Note showNote();
}
