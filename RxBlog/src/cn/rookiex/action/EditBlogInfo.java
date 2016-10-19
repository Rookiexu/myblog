package cn.rookiex.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.rookiex.po.BlogInfo;
import cn.rookiex.service.BlogInfoService;

public class EditBlogInfo extends ActionSupport {
	private String blogtitle;
	private String idiograph;
	private BlogInfoService blogInfoService;
	
	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	
	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getIdiograph() {
		return idiograph;
	}

	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	public String execute() throws Exception {
		/*HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");*/
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setUsername(username);
		blogInfo.setBlogtitle(blogtitle);
		blogInfo.setIdiograph(idiograph);
		
		blogInfoService.setBlogInfo(blogInfo);
		return SUCCESS;
	}

}
