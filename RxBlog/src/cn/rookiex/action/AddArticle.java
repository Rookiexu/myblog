package cn.rookiex.action;

import java.util.Date;
import java.util.Map;

import cn.rookiex.po.Article;
import cn.rookiex.service.ArticleService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddArticle extends ActionSupport {
	private String title;
	private String content;
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		/*String my = "xzsxzs";
		
		if(my.equals(username)) {
		} 	else {	
			return NONE;
		}*/
		//封装一个PO类的对象
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setUsername(username);
		article.setDate(new Date());
		articleService.addArticle(article);
		return this.SUCCESS;
	}
}
