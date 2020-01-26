package com.mypayrollmaster.dto;

public class SubmitResponse {

	public SubmitResponse(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	private boolean success;
	private String msg;
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
	
	
}
