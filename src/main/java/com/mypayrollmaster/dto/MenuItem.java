package com.mypayrollmaster.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuItem {

	private Long id;
	private String text;
	private String iconCls;
	private String rowCls;
	private String viewType;
	private String routeId;
	private boolean leaf = true;
	private boolean expanded = false;
	private boolean selectable = false;
	
	private List<MenuItem> children = new ArrayList<MenuItem>() ;
	
	public MenuItem() {
		super();
	}
	
	public MenuItem(String text, String iconCls, String viewType, boolean leaf) {
		super();
		this.text = text;
		this.iconCls = iconCls;
		this.viewType = viewType;
		this.leaf = leaf;
	}

	public MenuItem(String text, String iconCls, String viewType, String routeId, boolean leaf) {
		super();
		this.text = text;
		this.iconCls = iconCls;
		this.viewType = viewType;
		this.routeId = routeId;
		this.leaf = leaf;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getRowCls() {
		return rowCls;
	}
	public void setRowCls(String rowCls) {
		this.rowCls = rowCls;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public List<MenuItem> getChildren() {
		return children;
	}

	public void setChildren(List<MenuItem> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
	
	
}
