package cn.rookiex.service;

import java.util.List;

import cn.rookiex.dao.NoteDAO;
import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.PageUtil;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Note;

public class NoteServiceImpl implements NoteService {
	

	private NoteDAO noteDAO;

	public NoteDAO getNoteDAO() {
		return noteDAO;
	}
	
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}
	@Override
	public void addNote(Note note) {
		noteDAO.addNote(note);
	}

	@Override
	public Result showNoteByPage(Page page) {
		page = PageUtil.createPage(page,noteDAO.queryNoteCount());
		List<Note> all = noteDAO.queryByPage(page);
		Result result = new Result();
		result.setPage(page);
		result.setList(all);
		return result;
	}
	

	@Override
	public int getNoteCount() {
		return noteDAO.queryNoteCount();
	}

	public Note showNote() {
		return noteDAO.queryById();
	}
}
