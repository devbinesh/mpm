package com.mypayrollmaster.dto;

public class SubmitResponse<T> {
	private boolean success;
	private String msg;
	T data;
	public SubmitResponse(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public SubmitResponse(boolean success, String msg,T data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
