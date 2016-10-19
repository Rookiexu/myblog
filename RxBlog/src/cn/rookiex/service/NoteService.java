package cn.rookiex.service;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;

public interface NoteService {
	//�������
	public void addNote(Note note);
	//��ҳ��ʾ
	public Result showNoteByPage(Page page);
	//�����������
	public int getNoteCount();
	//��ʾ����
	public Note showNote();
}
