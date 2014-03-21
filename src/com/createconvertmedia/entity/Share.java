package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Share extends Transaction {
	/**
	share_transaction_history Table
	id 									long integer primary key ai
	server_id 							long
	*server_user_id 						long 
	server_amount_invested 				long
	server_share_value 					real
	server_total_share_purchased 		long
	server_share_added_date 			text
	server_created 						text
	server_modified 					text
	server_status 						integer
	 */
	
	/**
	 * The databsase key which handles
	 * the database handlers data 
	 * for share table
	 * @author David B. Montecillo
	 *
	 */
	public final static class DatabaseKey {
		public String ID = "id";
		public String SERVER_ID = "server_id";
		public String SERVER_AMOUNT_INVESTED = "server_amount_invested";
		public String SERVER_SHARE_VALUE = "server_share_value";
		public String SERVER_TOTAL_SHARE_PURCHASED = "server_total_share_purchased";
		public String SERVER_SHARED_ADDED_DATE = "server_shared_added_date";
		public String SERVER_CREATED = "server_created";
		public String SERVER_MODIFIED = "server_modified";
		public String SERVER_STATUS = "server_status";
		
		public String TABLE = "Share_transaction_history";
		
		public String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
				+  SERVER_ID + " INTEGER , " + SERVER_AMOUNT_INVESTED + " INTEGER , " + SERVER_SHARE_VALUE + " REAL , " 
				+  SERVER_TOTAL_SHARE_PURCHASED + " INTEGER , " + SERVER_SHARED_ADDED_DATE + " TEXT , "  + SERVER_CREATED + " TEXT , "
				+  SERVER_MODIFIED + " TEXT , " + SERVER_STATUS + " INTEGER );";
		
		public String INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_ID + "x ON " + TABLE + "(" + SERVER_ID + ");"   ;
	
		public String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;
	}
	
	
	@SerializedName("amount_invested")
	private long server_amount_invested;
	
	@SerializedName("share_value")
	private double server_share_value;
	
	@SerializedName("total_share_purchased")
	private long server_total_share_purchased;
	
	@SerializedName("share_added_date")
	private String server_share_added_date;
	
	@SerializedName("created")
	private String server_created;
	
	@SerializedName("modified")
	private String server_modified;
	
	@SerializedName("status")
	private int server_status;

	
	public Share(){}
	
	public Share(long id, long server_id , long user_id, long server_amount_invested, double server_share_value,
			long server_total_share_purchased, String server_share_added_date,
			String server_created, String server_modified, int server_status) {
		super(id, server_id, user_id);
		this.server_amount_invested = server_amount_invested;
		this.server_share_value = server_share_value;
		this.server_total_share_purchased = server_total_share_purchased;
		this.server_share_added_date = server_share_added_date;
		this.server_created = server_created;
		this.server_modified = server_modified;
		this.server_status = server_status;
	}

	public long getServer_amount_invested() {
		return server_amount_invested;
	}

	public void setServer_amount_invested(long server_amount_invested) {
		this.server_amount_invested = server_amount_invested;
	}

	public double getServer_share_value() {
		return server_share_value;
	}

	public void setServer_share_value(double server_share_value) {
		this.server_share_value = server_share_value;
	}

	public long getServer_total_share_purchased() {
		return server_total_share_purchased;
	}

	public void setServer_total_share_purchased(long server_total_share_purchased) {
		this.server_total_share_purchased = server_total_share_purchased;
	}

	public String getServer_share_added_date() {
		return server_share_added_date;
	}

	public void setServer_share_added_date(String server_share_added_date) {
		this.server_share_added_date = server_share_added_date;
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
