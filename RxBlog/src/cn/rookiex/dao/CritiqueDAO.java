package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.fenye.Page;
import cn.rookiex.po.Critique;

public interface CritiqueDAO {
	public void addCritique(Critique critique);
	//获得指定文章的评论数
	public int queryCritiqueCount(int AId);
	
	//根据Page来查询指定文章的评论
	public List<Critique> queryByPage(int AId,Page page);
}
