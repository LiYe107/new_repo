package org.springcloud.eureka.client.shiro.service;

import org.springcloud.eureka.client.shiro.dao.UserInfoRepository;
import org.springcloud.eureka.client.shiro.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoRepository userInfoRepostitory;

	@Override
	public UserInfo findByUsername(String username) {
		return userInfoRepostitory.findByUsername(username);
	}

	
}
