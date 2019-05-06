package org.springcloud.eureka.client.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping("/userInfo")
public class UserInfoController {

	@RequestMapping("/userList")
	@RequiresPermissions({"userInfo:view"})
	public String userInfo() {
		return "userInfo";
	}
	
	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add")
	public String userAdd() {
		return "userInfoAdd";
	}
	
	@RequestMapping("/userDel")
	@RequiresPermissions("userInfo:del")
	public String userDel() {
		return "userInfoDel";
	}
	
	@RequestMapping("/userMod")
	@RequiresPermissions("userInfo:mod")
	public String userMod() {
		return "userInfoMod";
	}
}
