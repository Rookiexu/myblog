package cn.rookiex.service;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Critique;

public interface CritiqueService {
	//添加评论
	public void addCritique(Critique critique);
	//分页显示评论
	public Result showCritiqueByPage(int AId,Page page);
	
	public int getCritiqueCount(int AId);
}
