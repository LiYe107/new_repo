package org.springcloud.eureka.client.shiro.dao;

import org.springcloud.eureka.client.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>  {
	public UserInfo findByUsername(String username);
}
