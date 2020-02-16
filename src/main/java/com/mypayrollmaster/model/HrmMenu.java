package com.mypayrollmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrm_menu")
public class HrmMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "menu_id")
	private Long id;
	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "menu_url")
	private String menuUrl;
	
	@Column(name = "menu_title")
	private String menuTitle;
	
	@Column(name = "menu_name")
	private String menuName;
	
	@Column(name = "active")
	private String 	active;
	
	@Column(name = "iconCls")
	private String 	iconCls;
	
	@Column(name = "user_id")
	private Long 	userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
