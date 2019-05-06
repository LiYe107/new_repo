package org.springcloud.eureka.client.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/403")
	public String unAuth() {
		return "403";
	}
	
	@RequestMapping("/login") 
	public String login(HttpServletRequest request, Model model) {
		//获取shiro进行登录验证的处理结果
		String exception = (String) request.getAttribute("shiroLoginFailure");
		String msg = "";
		if(exception!=null) {
			if(UnknownAccountException.class.getName().equals(exception)) {
				msg = "账号不存在";
			} else if(IncorrectCredentialsException.class.getName().equals(exception)) {
				msg = "密码错误";
			} else if("kaptchaValidateFailed".equals(exception)) {
				msg = "校验码错误";
			} else {
				msg = "登录异常：" + exception;
			}
			model.addAttribute("loginErrorMsg", msg);
		}
		return "login";
	}
	
}






