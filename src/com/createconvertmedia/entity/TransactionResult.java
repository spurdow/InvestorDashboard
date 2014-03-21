package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TransactionResult extends Result{
	
	@SerializedName("share")
	private List<Share> shares;
	
	@SerializedName("withdrawals")
	private List<Withdrawal> withdrawals;
	

	public TransactionResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionResult(List<Share> shares, List<Withdrawal> withdrawals) {
		super("status","message");
		this.shares = shares;
		this.withdrawals = withdrawals;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<Withdrawal> getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(List<Withdrawal> withdrawals) {
		this.withdrawals = withdrawals;
	}
	
	
}
