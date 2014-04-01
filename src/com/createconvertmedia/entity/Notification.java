package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Notification {
	

	
	@SerializedName("notification_id")
	private int notification_id;

	@SerializedName("projects")
	private List<Project> projects;

	
	@SerializedName("collapse_key")
	private String collapse_key;
	
	@SerializedName("from")
	private String from;
	
	@SerializedName("notify")
	private boolean notify;

	
	
	public Notification(boolean notify, int notification_id,
			String collapse_key,  String from) {
		super();
		this.notify = notify;
		this.notification_id = notification_id;
		this.collapse_key = collapse_key;
		this.from = from;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public int getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}

	public String getCollapse_key() {
		return collapse_key;
	}

	public void setCollapse_key(String collapse_key) {
		this.collapse_key = collapse_key;
	}


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
}
