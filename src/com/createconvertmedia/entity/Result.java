package com.createconvertmedia.entity;


import com.google.gson.annotations.SerializedName;

public class Result {
	@SerializedName("status")
	private String status;
	
	@SerializedName("message")
	private String message;

	public Result(){}

	public Result(String status , String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
