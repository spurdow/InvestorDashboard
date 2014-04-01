package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class LoginResult extends Result{
	
	@SerializedName("user")
	private User user;
	
	@SerializedName("investor")
	private Investor investor;
	
	@SerializedName("project_names")
	private List<String> names;
	
	@SerializedName("projects")
	private List<Project> projects;



	public LoginResult(User user, Investor investor  , List<Project> projeccts , List<String> names) {
		super();
		this.user = user;
		this.investor = investor;
		this.projects = projeccts;
		this.names = names;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	
	
	
}
