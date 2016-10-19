package cn.rookiex.dao;

import java.util.List;

import cn.rookiex.fenye.Page;
import cn.rookiex.po.Critique;

public interface CritiqueDAO {
	public void addCritique(Critique critique);
	//���ָ�����µ�������
	public int queryCritiqueCount(int AId);
	
	//����Page����ѯָ�����µ�����
	public List<Critique> queryByPage(int AId,Page page);
}
