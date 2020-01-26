package com.mypayrollmaster.dto;

import java.util.List;

public class Response {

	private String msg;
	private boolean success;
	
	 
	
	public String getMessage() {
		return msg;
	}
	public Response setMessage(String message) {
		this.msg = message;
		return this;
	}
	public boolean isSuccess() {
		return success;
	}
	public Response setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	
	public static Response build() {
		return new Response();
	}
	
	
}
