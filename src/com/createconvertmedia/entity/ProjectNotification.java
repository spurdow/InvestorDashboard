package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProjectNotification extends Notification {

	@SerializedName("projects")
	private List<Project> projects;
	


	public ProjectNotification(boolean notify, int notification_id,
			String collapse_key, String from, List<Project> projects) {
		super(notify, notification_id, collapse_key, from);
		this.projects = projects;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
