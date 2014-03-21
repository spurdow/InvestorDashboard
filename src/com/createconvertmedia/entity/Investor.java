package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Investor {
	
	
	/**
	- From server tbl_investor
	server_i_id		 					long
	server_i_user_id 					long
	server_i_account_number 			text
	server_i_user_picture 				text
	server_i_password_picture 			text
	server_i_address 					text
	server_i_city 						text
	server_i_state 						text
	server_i_country 					text
	server_i_zip 						text
	server_i_phone 						text
	server_i_created	  				text
	server_i_modified 					text
	server_i_status 					integer
	server_i_share_type 				integer
	 */
	@SerializedName("id")
	private long server_i_id;
	
	@SerializedName("user_id")
	private long server_i_user_id;
	
	@SerializedName("account_number")
	private String server_i_account_number;

	@SerializedName("user_picture")
	private String server_i_user_picture;
	
	@SerializedName("password_picture")
	private String server_i_password_picture;
	
	@SerializedName("address")
	private String server_i_address;
	
	@SerializedName("city")
	private String server_i_city;
	
	@SerializedName("state")
	private String server_i_state;
	
	@SerializedName("country")
	private String server_i_country;
	
	@SerializedName("zip")
	private String server_i_zip;
	
	@SerializedName("phone")
	private String server_i_phone;
	
	@SerializedName("created")
	private String server_i_created;
	
	@SerializedName("modified")
	private String server_i_modified;
	
	@SerializedName("status")
	private int server_i_status;
	
	@SerializedName("share_type")
	private int server_i_share_type;
	

	
	
	



	public Investor(long server_i_id, long server_i_user_id,
			String server_i_user_picture, String server_i_password_picture,
			String server_i_address, String server_i_city,
			String server_i_state, String server_i_country,
			String server_i_zip, String server_i_phone,
			String server_i_created, String server_i_modified,
			int server_i_status, int server_i_share_type, long server_u_id,
			String server_u_name, String server_u_username,
			String server_u_email, String server_u_password,
			String server_u_role, int server_u_status,
			String server_u_stats_notify_year, int server_u_stats_notify_month,
			String server_u_stats_notify_half, int server_u_system_mail_status,
			int server_u_halfmonth_status, String server_u_last_login) {
		
		this.server_i_id = server_i_id;
		this.server_i_user_id = server_i_user_id;
		this.server_i_user_picture = server_i_user_picture;
		this.server_i_password_picture = server_i_password_picture;
		this.server_i_address = server_i_address;
		this.server_i_city = server_i_city;
		this.server_i_state = server_i_state;
		this.server_i_country = server_i_country;
		this.server_i_zip = server_i_zip;
		this.server_i_phone = server_i_phone;
		this.server_i_created = server_i_created;
		this.server_i_modified = server_i_modified;
		this.server_i_status = server_i_status;
		this.server_i_share_type = server_i_share_type;
	
	}




	public long getServer_i_id() {
		return server_i_id;
	}



	public void setServer_i_id(long server_i_id) {
		this.server_i_id = server_i_id;
	}



	public long getServer_i_user_id() {
		return server_i_user_id;
	}



	public void setServer_i_user_id(long server_i_user_id) {
		this.server_i_user_id = server_i_user_id;
	}



	public String getServer_i_user_picture() {
		return server_i_user_picture;
	}



	public void setServer_i_user_picture(String server_i_user_picture) {
		this.server_i_user_picture = server_i_user_picture;
	}



	public String getServer_i_password_picture() {
		return server_i_password_picture;
	}



	public void setServer_i_password_picture(String server_i_password_picture) {
		this.server_i_password_picture = server_i_password_picture;
	}



	public String getServer_i_address() {
		return server_i_address;
	}



	public void setServer_i_address(String server_i_address) {
		this.server_i_address = server_i_address;
	}



	public String getServer_i_city() {
		return server_i_city;
	}



	public void setServer_i_city(String server_i_city) {
		this.server_i_city = server_i_city;
	}



	public String getServer_i_state() {
		return server_i_state;
	}



	public void setServer_i_state(String server_i_state) {
		this.server_i_state = server_i_state;
	}



	public String getServer_i_country() {
		return server_i_country;
	}



	public void setServer_i_country(String server_i_country) {
		this.server_i_country = server_i_country;
	}



	public String getServer_i_zip() {
		return server_i_zip;
	}



	public void setServer_i_zip(String server_i_zip) {
		this.server_i_zip = server_i_zip;
	}



	public String getServer_i_phone() {
		return server_i_phone;
	}



	public void setServer_i_phone(String server_i_phone) {
		this.server_i_phone = server_i_phone;
	}



	public String getServer_i_created() {
		return server_i_created;
	}



	public void setServer_i_created(String server_i_created) {
		this.server_i_created = server_i_created;
	}



	public String getServer_i_modified() {
		return server_i_modified;
	}



	public void setServer_i_modified(String server_i_modified) {
		this.server_i_modified = server_i_modified;
	}



	public int getServer_i_status() {
		return server_i_status;
	}



	public void setServer_i_status(int server_i_status) {
		this.server_i_status = server_i_status;
	}



	public int getServer_i_share_type() {
		return server_i_share_type;
	}



	public void setServer_i_share_type(int server_i_share_type) {
		this.server_i_share_type = server_i_share_type;
	}


}
