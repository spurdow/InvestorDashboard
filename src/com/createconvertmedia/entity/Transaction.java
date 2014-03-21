package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Transaction {
	
	private long id;
	
	@SerializedName("id")
	private long server_id;
	
	@SerializedName("user_id")
	private long server_user_id;
	
	public Transaction(){}
	
	public Transaction(long id, long server_id, long server_user_id) {
		super();
		this.id = id;
		this.server_id = server_id;
		this.server_user_id = server_user_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getServer_id() {
		return server_id;
	}

	public void setServer_id(long server_id) {
		this.server_id = server_id;
	}

	public long getServer_user_id() {
		return server_user_id;
	}

	public void setServer_user_id(long server_user_id) {
		this.server_user_id = server_user_id;
	}
	
	
}
