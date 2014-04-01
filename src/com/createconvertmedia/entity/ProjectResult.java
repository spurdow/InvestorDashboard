package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProjectResult extends Result{
	
	@SerializedName("projects")
	private List<Project> quarter;

	
	public ProjectResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectResult(String status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}


	public ProjectResult(List<Project> quarter) {
		super();
		this.quarter = quarter;
	}


	public List<Project> getQuarter() {
		return quarter;
	}


	public void setQuarter(List<Project> quarter) {
		this.quarter = quarter;
	}
	
	
	
	
}
