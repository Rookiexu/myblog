package cn.rookiex.action;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.rookiex.fenye.Page;
import cn.rookiex.fenye.Result;
import cn.rookiex.po.Article;
import cn.rookiex.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAllArticle extends ActionSupport{
	private ArticleService articleService;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public String execute() throws Exception {
		//通过调用业务逻辑组件来完成查询
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(10);
		
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		List<Article> all = result.getList();
		
		//把查询到的结果保存在一个范围，request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("all", all);
		request.setAttribute("page", page);
		return this.SUCCESS;
	}
	
}
