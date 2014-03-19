package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Result {
	@SerializedName("status")
	private String status;


	public Result(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
