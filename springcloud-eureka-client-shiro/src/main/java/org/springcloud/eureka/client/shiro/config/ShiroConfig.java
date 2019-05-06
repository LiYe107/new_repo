package org.springcloud.eureka.client.shiro.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;

@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("/static/**", "anon");
		map.put("/logout", "logout");
		map.put("/**", "authc");
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/index");
		bean.setUnauthorizedUrl("/403");
		bean.setFilterChainDefinitionMap(map);
		return bean;
	}
	
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(2);
		return matcher;
	}
	
	@Bean
	public SysShiroRealm sysShiroRealm() {
		SysShiroRealm realm = new SysShiroRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}
	
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(sysShiroRealm());
		return manager;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor 
		authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
	//异常处理器
	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties props = new Properties();
		props.setProperty("DatabaseException", "databaseError");//数据库异常处理
		props.setProperty("UnauthorizedException","403");
		resolver.setExceptionMappings(props);
		resolver.setDefaultErrorView("error");
		resolver.setExceptionAttribute("ex");
		return resolver;
	}
}







