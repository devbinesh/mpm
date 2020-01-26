package com.mypayrollmaster.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public class ListResponse<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	private Long totalCount;
	private Page<T> data;
	private List<T> list;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	private boolean success;
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	 
	public Page<T> getData() {
		return data;
	}
	public void setData(Page<T> data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	 
	
}
