package cn.rookiex.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.rookiex.fenye.Page;
import cn.rookiex.po.Article;
import cn.rookiex.po.Note;

public class NoteDAOImpl  extends HibernateDaoSupport implements NoteDAO {

	@Override
	public void addNote(Note note) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(note);
	}

	@Override
	public int queryNoteCount() {
		List find = this.getHibernateTemplate().find("select count(*) from Note note");
		
		return ((Long)find.get(0)).intValue();	
	}

	@Override
	public List<Note> queryByPage(Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select note from Note note");
				//设置每页显示多少个，设置多大结果。
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}
	
	public Note queryById() {
		List find = this.getHibernateTemplate().find("select note from Note note");
		return (Note) find.get(0);
	}

}
