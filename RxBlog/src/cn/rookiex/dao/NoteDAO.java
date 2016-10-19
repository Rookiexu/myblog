package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.fenye.Page;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;

public interface NoteDAO {
	//添加留言
	public void addNote(Note note);
	//获得留言板的留言数
	public int queryNoteCount();
	
	//根据Page来查询留言
	public List<Note> queryByPage(Page page);
	
	//按ID查询文章
	public Note queryById();
}
