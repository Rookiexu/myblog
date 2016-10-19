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


		// 业务逻辑组件属性
		private ArticleService articleService;
		// id属性
		private int id;
		// 评论的业务逻辑组件
		private CritiqueService critiqueService;
		//设置当前页
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
			// 将文章设置到request范围
			HttpServletRequest request = ServletActionContext.getRequest();
			// 按ID查询文章
			Article article = articleService.showArticle(id);
			// 获得用户IP
			String IP = request.getRemoteAddr();
			// 获得当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String stime = sdf.format(new Date());
			Date time = sdf.parse(stime);

			// 将更新的Article保存到数据表中
			articleService.addArticle(article);
			
			
			//显示评论
			Page page = new Page();
			page.setCurrentPage(this.getCurrentPage());
			page.setEveryPage(5);
			
			Result result = critiqueService.showCritiqueByPage(id, page);
			
			request.setAttribute("page", result.getPage());
			request.setAttribute("allCri", result.getList());
			request.setAttribute("article", article);
			
			/*取得个性化设置
			if(username != null || !"".equals(username)) {
				Map session = ActionContext.getContext().getSession();
				BlogInfo bloginfo  = BlogInfoService.getBlogInfo(username);
				if(bloginfo != null) {
					session.put("blogtitle", bloginfo.getBlogtitle());
					session.put("idiograph", bloginfo.getIdiograph());
				}
			}
			通过业务逻辑组件来查询*/
			return this.SUCCESS;
		}

}
