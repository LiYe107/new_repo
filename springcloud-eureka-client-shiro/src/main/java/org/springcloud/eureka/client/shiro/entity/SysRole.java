package org.springcloud.eureka.client.shiro.entity;

import java.util.List;

import javax.persistence.*;
/**
 * 保存系统角色的实体类
 * @author liye
 */
@Entity
public class SysRole {
	@Id
	@GeneratedValue
	private int id;
	private Boolean available = Boolean.FALSE;
	private String description;
	private String role;
	@ManyToMany(fetch=FetchType.EAGER)//表示立即加载权限数据
	@JoinTable(name="SysRolePermission", joinColumns= {@JoinColumn(name="roleId")}, 
		inverseJoinColumns= {@JoinColumn(name="permissionId")})
	private List<SysPermission> permissions;//当前角色所有的权限
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", available=" + available + ", description=" + description + ", role=" + role
				+ ", permissions=" + permissions + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
}
