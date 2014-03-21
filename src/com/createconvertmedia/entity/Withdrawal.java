package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Withdrawal extends Transaction {
	/**
	Withdrawals_history Table
	id 									long integer primary key ai
	server_id 							long
	*server_user_id 						long
	server_account_type 				text
	server_amount 						real
	server_requested_date 				text
	server_withdrawal_status 			text
	server_comment 						text
	server_reply_date 					text
	server_created 						text
	server_modified 					text
	server_status 						intger
	 */
	/**
	 * Database key for withdrawal
	 * @author David Montecillo
	 *
	 */
	public static class DatabaseKey{
		public String ID = "id";
		public String SERVER_ID = "server_id";
		public String SERVER_ACCOUNT_TYPE = "server_account_type";
		public String SERVER_AMOUNT = "server_amount";
		public String SERVER_REQUESTED_DATE = "server_requested_date";
		public String SERVER_WITHDRAWAL_STATUS = "server_withdrawal_status";
		public String SERVER_COMMENT = "server_comment";
		public String SERVER_REPLY_DATE = "server_reply_date";
		public String SERVER_CREATED = "server_created";
		public String SERVER_MODIFIED = "server_modified";
		public String SERVER_STATUS = "server_status";
		
		public String TABLE = "Withdrawal_transaction_history";
		
		public String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
				+ SERVER_ID + " INTEGER , " + SERVER_ACCOUNT_TYPE + " TEXT , " + SERVER_AMOUNT + " REAL, " + SERVER_REQUESTED_DATE + " TEXT , "
				+ SERVER_WITHDRAWAL_STATUS + " TEXT , " + SERVER_COMMENT + " TEXT , " + SERVER_REPLY_DATE + " TEXT , " + SERVER_COMMENT + " TEXT , "
				+ SERVER_REPLY_DATE + " TEXT , " + SERVER_CREATED + " TEXT , " + SERVER_MODIFIED + " TEXT , " + SERVER_STATUS + " INTEGER );" ;
		
		public String INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_ID + "x ON " + TABLE + "(" + SERVER_ID + ");"   ;
	
		public String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;
	}
	
	@SerializedName("account_type")
	private String server_account_type;
	
	@SerializedName("amount")
	private double server_amount;
	
	@SerializedName("requested_date")
	private String server_requested_date;
	
	@SerializedName("withdrawal_status")
	private String server_withdrawal_status;
	
	@SerializedName("comment")
	private String server_comment;
	
	@SerializedName("reply_date")
	private String server_reply_date;
	
	@SerializedName("created")
	private String server_created;
	
	@SerializedName("modified")
	private String server_modified;
	
	@SerializedName("status")
	private int server_status;


	
	
	public Withdrawal(long id , long server_id, long user_id ,String server_account_type, double server_amount,
			String server_requested_date, String server_withdrawal_status,
			String server_comment, String server_reply_date,
			String server_created, String server_modified, int server_status) {
		super(id, server_id, user_id);
		this.server_account_type = server_account_type;
		this.server_amount = server_amount;
		this.server_requested_date = server_requested_date;
		this.server_withdrawal_status = server_withdrawal_status;
		this.server_comment = server_comment;
		this.server_reply_date = server_reply_date;
		this.server_created = server_created;
		this.server_modified = server_modified;
		this.server_status = server_status;
	}

	public String getServer_account_type() {
		return server_account_type;
	}

	public void setServer_account_type(String server_account_type) {
		this.server_account_type = server_account_type;
	}

	public double getServer_amount() {
		return server_amount;
	}

	public void setServer_amount(double server_amount) {
		this.server_amount = server_amount;
	}

	public String getServer_requested_date() {
		return server_requested_date;
	}

	public void setServer_requested_date(String server_requested_date) {
		this.server_requested_date = server_requested_date;
	}

	public String getServer_withdrawal_status() {
		return server_withdrawal_status;
	}

	public void setServer_withdrawal_status(String server_withdrawal_status) {
		this.server_withdrawal_status = server_withdrawal_status;
	}

	public String getServer_comment() {
		return server_comment;
	}

	public void setServer_comment(String server_comment) {
		this.server_comment = server_comment;
	}

	public String getServer_reply_date() {
		return server_reply_date;
	}

	public void setServer_reply_date(String server_reply_date) {
		this.server_reply_date = server_reply_date;
	}

	public String getServer_created() {
		return server_created;
	}

	public void setServer_created(String server_created) {
		this.server_created = server_created;
	}

	public String getServer_modified() {
		return server_modified;
	}

	public void setServer_modified(String server_modified) {
		this.server_modified = server_modified;
	}

	public int getServer_status() {
		return server_status;
	}

	public void setServer_status(int server_status) {
		this.server_status = server_status;
	}
	
	
	
	
}
