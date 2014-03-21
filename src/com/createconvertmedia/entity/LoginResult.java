package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class LoginResult extends Result{
	
	@SerializedName("user")
	private User user;
	
	@SerializedName("investor")
	private Investor investor;
	
	

	public LoginResult(User user, Investor investor) {
		super();
		this.user = user;
		this.investor = investor;
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
	
	
}
