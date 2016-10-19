package cn.rookiex.service;

import java.util.List;

import cn.rookiex.dao.CritiqueDAO;
import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.PageUtil;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Critique;

public class CritiqueServiceImpl implements CritiqueService {
	
		private CritiqueDAO critiqueDAO;

		public CritiqueDAO getCritiqueDAO() {
			return critiqueDAO;
		}

		public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
			this.critiqueDAO = critiqueDAO;
		}

		public void addCritique(Critique critique) {
			critiqueDAO.addCritique(critique);
		}
		public Result showCritiqueByPage(int AId, Page page) {
			page = PageUtil.createPage(page,critiqueDAO.queryCritiqueCount(AId));
			List<Critique> all = critiqueDAO.queryByPage(AId, page);
			Result result = new Result();
			result.setPage(page);
			result.setList(all);
			return result;
		}
		
		public int getCritiqueCount(int AId) {
			return critiqueDAO.queryCritiqueCount(AId);
		}

}
