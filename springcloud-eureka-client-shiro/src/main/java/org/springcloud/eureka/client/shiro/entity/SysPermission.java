package org.springcloud.eureka.client.shiro.entity;

import javax.persistence.*;

/**
 * 保存权限信息的实体类
 * @author liye
 */
@Entity
public class SysPermission {
	@Id
	@GeneratedValue
	private int id;
	private boolean available = Boolean.FALSE;
	private String name;
	private Long parentId;
	private String parentIds;
	private String permission;
	@Column(columnDefinition="enum('menu','button')")
	private String resourceType;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "SysPermission [id=" + id + ", available=" + available + ", name=" + name + ", parentId=" + parentId
				+ ", parentIds=" + parentIds + ", permission=" + permission + ", resourceType=" + resourceType
				+ ", url=" + url + "]";
	}
	
}
