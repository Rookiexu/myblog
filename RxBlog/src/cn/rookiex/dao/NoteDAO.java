package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.fenye.Page;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;

public interface NoteDAO {
	//�������
	public void addNote(Note note);
	//������԰��������
	public int queryNoteCount();
	
	//����Page����ѯ����
	public List<Note> queryByPage(Page page);
	
	//��ID��ѯ����
	public Note queryById();
}
