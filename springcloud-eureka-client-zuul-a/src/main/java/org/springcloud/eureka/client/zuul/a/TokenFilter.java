package org.springcloud.eureka.client.zuul.a;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

//定义过滤器，判断当前访问服务的请求是否带有正确的令牌信息
@Component
public class TokenFilter extends ZuulFilter {
	
	@Value("${token.key}")
	String key;

	@Override
	public boolean shouldFilter() {//定义过滤器要不要执行
		return true;
	}

	@Override
	public String filterType() {//过滤器的类别，定义执行时机
		return "pre";
	}
	
	@Override
	public int filterOrder() {//定义同类别过滤器执行顺序的
		return 0;
	}

	@Override
	public Object run() {
		//1.获取应用程序上下文对象
		RequestContext cxt = RequestContext.getCurrentContext();
		//2.获取请求对象及token参数
		HttpServletRequest request = cxt.getRequest();
		String token = request.getParameter("token");
		//3.判断token正确与否
		if(token==null || !token.equals(key)) {//无访问权限，直接结束当前访问
			cxt.setResponseStatusCode(401);
			cxt.setSendZuulResponse(false);
			try {
				cxt.getResponse().getWriter().write("Token is error.");
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		//4.token正确则不做处理，token错误则结束请求
		return null;
	}


}
