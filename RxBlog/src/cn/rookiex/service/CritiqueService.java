package cn.rookiex.service;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Critique;

public interface CritiqueService {
	//�������
	public void addCritique(Critique critique);
	//��ҳ��ʾ����
	public Result showCritiqueByPage(int AId,Page page);
	
	public int getCritiqueCount(int AId);
}
