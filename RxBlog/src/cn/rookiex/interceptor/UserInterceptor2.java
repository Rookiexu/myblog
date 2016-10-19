package cn.rookiex.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor2 extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context =invocation.getInvocationContext();
		//���session
		Map session = context.getContext().getSession();
		String username = (String) session.get("username");
		String my = "xzsxzs";
		//�ж��û��Ϸ���
	
		if (my.equals(username)) {
			 System.out.print(my+"001");
			return invocation.invoke();
		 } else{
		//������һ��������û������
		System.out.print(username);
		return Action.NONE;
		}
	
	}

}
