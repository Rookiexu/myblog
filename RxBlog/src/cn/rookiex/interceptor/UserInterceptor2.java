package cn.rookiex.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor2 extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context =invocation.getInvocationContext();
		//获得session
		Map session = context.getContext().getSession();
		String username = (String) session.get("username");
		String my = "xzsxzs";
		//判断用户合法性
	
		if (my.equals(username)) {
			 System.out.print(my+"001");
			return invocation.invoke();
		 } else{
		//进行下一步操作，没有拦截
		System.out.print(username);
		return Action.NONE;
		}
	
	}

}
