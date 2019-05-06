package org.springcloud.eureka.client.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springcloud.eureka.client.shiro.entity.SysPermission;
import org.springcloud.eureka.client.shiro.entity.SysRole;
import org.springcloud.eureka.client.shiro.entity.UserInfo;
import org.springcloud.eureka.client.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysShiroRealm extends AuthorizingRealm {
	
	@Autowired
	UserInfoService userInfoService;

	//返回授权信息的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();//当前登录系统用户对象
		//依次将用户角色和权限信息添加到AuthorizationInfo中
		for(SysRole r : userInfo.getRoles()) {
			info.addRole(r.getRole());
			for(SysPermission p : r.getPermissions()) {
				info.addStringPermission(p.getPermission());
			}
		}
		return info;
	}
	//返回认证信息的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();//获取当前登录的用户名
		UserInfo userInfo = userInfoService.findByUsername(username);
		if(userInfo==null) {
			return null;
		} 
		SimpleAuthenticationInfo info //将当前的登录用户信息封装成一个AuthenticationInfo对象
			= new SimpleAuthenticationInfo(userInfo, 
					userInfo.getPassword(), 
					ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
					getName());
		return info;
	}

}






