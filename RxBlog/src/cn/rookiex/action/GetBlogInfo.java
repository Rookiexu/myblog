package cn.rookiex.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.rookiex.po.BlogInfo;
import cn.rookiex.service.BlogInfoService;

public class GetBlogInfo extends ActionSupport {

	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}
	
	public String execute() throws Exception {
		//���username
		//Map session = ActionContext.getContext().getSession();
		//String username = (String) session.get("username");
		Map session = ActionContext.getContext().getSession();
		String username = "xzsxzs";
		//ͨ��ҵ���߼��������ѯ
		BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
		
		if(bloginfo != null) {
			session.put("blogtitle", bloginfo.getBlogtitle());
			session.put("idiograph", bloginfo.getIdiograph());
		}

		return this.SUCCESS;
	}
}
