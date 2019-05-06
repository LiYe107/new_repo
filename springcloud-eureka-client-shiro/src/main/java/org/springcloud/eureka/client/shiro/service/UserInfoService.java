package org.springcloud.eureka.client.shiro.service;

import org.springcloud.eureka.client.shiro.entity.UserInfo;

public interface UserInfoService {
	UserInfo findByUsername(String username);
}
