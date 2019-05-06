package org.springcloud.eureka.client.shiro.entity;

import java.util.List;

import javax.persistence.*;

/**
 * 存储系统用户信息的实体类
 * @author liye
 */
@Entity
public class UserInfo {
	@Id
	@GeneratedValue
	private Integer uid;
	@Column(unique=true)
	private String username;
	private String password;
	private String salt;
	private String name;
	private Byte state;
	
	/**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="SysUserRole", joinColumns=@JoinColumn(name="uid"), 
		inverseJoinColumns=@JoinColumn(name="roleId"))
	private List<SysRole> roles;//保存当前用户所有的角色

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", name=" + name + ", state=" + state + ", roles=" + roles + "]";
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	
	
}



