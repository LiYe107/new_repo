package org.springcloud.eureka.client.shiro.dao;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springcloud.eureka.client.shiro.entity.SysRole;
import org.springcloud.eureka.client.shiro.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DaoTest {

//	@Resource
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Test
	public void test01() {
		UserInfo user = userInfoRepository.findByUsername("admin");
		System.out.println(user);
	}
	@Test
	public void test02() {
		UserInfo user = new UserInfo();
		user.setName("VIP2");
		user.setPassword("123456");
		user.setSalt("8d78869f470951332959580424d4bf4f");
		user.setUsername("VIP02");
		byte state = 0;
		user.setState(state);
		//List<SysRole> roles = new LinkedList<SysRole>();
		userInfoRepository.save(user);
		System.out.println("添加成功~");
	}
	
	
}
