package cn.rookiex.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Article;
import cn.rookiex.po.BlogInfo;
import cn.rookiex.service.ArticleService;
import cn.rookiex.service.BlogInfoService;
import cn.rookiex.service.CritiqueService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ShowArticle extends ActionSupport{


		// ҵ���߼��������
		private ArticleService articleService;
		// id����
		private int id;
		// ���۵�ҵ���߼����
		private CritiqueService critiqueService;
		//���õ�ǰҳ
		private int currentPage;

		private String username;
		
		public String getUsername() {
			return username;
		}

		private BlogInfoService BlogInfoService;

		public BlogInfoService getBlogInfoService() {
			return BlogInfoService;
		}

		public void setBlogInfoService(BlogInfoService blogInfoService) {
			this.BlogInfoService = blogInfoService;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public CritiqueService getCritiqueService() {
			return critiqueService;
		}

		public void setCritiqueService(CritiqueService critiqueService) {
			this.critiqueService = critiqueService;
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArticleService getArticleService() {
			return articleService;
		}

		public void setArticleService(ArticleService articleService) {
			this.articleService = articleService;
		}

		public String execute() throws Exception {
			// ���������õ�request��Χ
			HttpServletRequest request = ServletActionContext.getRequest();
			// ��ID��ѯ����
			Article article = articleService.showArticle(id);
			// ����û�IP
			String IP = request.getRemoteAddr();
			// ��õ�ǰʱ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String stime = sdf.format(new Date());
			Date time = sdf.parse(stime);

			// �����µ�Article���浽���ݱ���
			articleService.addArticle(article);
			
			
			//��ʾ����
			Page page = new Page();
			page.setCurrentPage(this.getCurrentPage());
			page.setEveryPage(5);
			
			Result result = critiqueService.showCritiqueByPage(id, page);
			
			request.setAttribute("page", result.getPage());
			request.setAttribute("allCri", result.getList());
			request.setAttribute("article", article);
			
			/*ȡ�ø��Ի�����
			if(username != null || !"".equals(username)) {
				Map session = ActionContext.getContext().getSession();
				BlogInfo bloginfo  = BlogInfoService.getBlogInfo(username);
				if(bloginfo != null) {
					session.put("blogtitle", bloginfo.getBlogtitle());
					session.put("idiograph", bloginfo.getIdiograph());
				}
			}
			ͨ��ҵ���߼��������ѯ*/
			return this.SUCCESS;
		}

}
