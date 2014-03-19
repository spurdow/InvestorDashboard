package com.createconvertmedia.entity;

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
	
	private long server_i_id;
	private long server_i_user_id;
	private String server_i_user_picture;
	private String server_i_password_picture;
	private String server_i_address;
	private String server_i_city;
	private String server_i_state;
	private String server_i_country;
	private String server_i_zip;
	private String server_i_phone;
	private String server_i_created;
	private String server_i_modified;
	private int server_i_status;
	private int server_i_share_type;
	
	/**
	 * From server tbl_user
	server_u_id 						long
	server_u_name 						text
	server_u_username 					text
	server_u_email 						text
	server_u_password 					text
	server_u_role 						text
	server_u_status 		 			integer
	server_u_stats_notify_year 			text
	server_u_stats_notify_month 		integer
	server_u_stats_notify_half 			text
	server_u_system_mail_status 		integer
	server_u_halfmonth_status 			integer
	server_u_last_login 				text
	 */
	
	private long server_u_id ;
	private String server_u_name;
	private String server_u_username;
	private String server_u_email;
	private String server_u_password;
	private String server_u_role;
	private int server_u_status;
	private String server_u_stats_notify_year;
	private int server_u_stats_notify_month ;
	private String server_u_stats_notify_half;
	private int server_u_system_mail_status;
	private int server_u_halfmonth_status;
	private String server_u_last_login;
	
	
	
	public Investor() {
		super();
	}

	


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
		super();
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
		this.server_u_id = server_u_id;
		this.server_u_name = server_u_name;
		this.server_u_username = server_u_username;
		this.server_u_email = server_u_email;
		this.server_u_password = server_u_password;
		this.server_u_role = server_u_role;
		this.server_u_status = server_u_status;
		this.server_u_stats_notify_year = server_u_stats_notify_year;
		this.server_u_stats_notify_month = server_u_stats_notify_month;
		this.server_u_stats_notify_half = server_u_stats_notify_half;
		this.server_u_system_mail_status = server_u_system_mail_status;
		this.server_u_halfmonth_status = server_u_halfmonth_status;
		this.server_u_last_login = server_u_last_login;
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



	public long getServer_u_id() {
		return server_u_id;
	}



	public void setServer_u_id(long server_u_id) {
		this.server_u_id = server_u_id;
	}



	public String getServer_u_name() {
		return server_u_name;
	}



	public void setServer_u_name(String server_u_name) {
		this.server_u_name = server_u_name;
	}



	public String getServer_u_username() {
		return server_u_username;
	}



	public void setServer_u_username(String server_u_username) {
		this.server_u_username = server_u_username;
	}



	public String getServer_u_email() {
		return server_u_email;
	}



	public void setServer_u_email(String server_u_email) {
		this.server_u_email = server_u_email;
	}



	public String getServer_u_password() {
		return server_u_password;
	}



	public void setServer_u_password(String server_u_password) {
		this.server_u_password = server_u_password;
	}



	public String getServer_u_role() {
		return server_u_role;
	}



	public void setServer_u_role(String server_u_role) {
		this.server_u_role = server_u_role;
	}



	public int getServer_u_status() {
		return server_u_status;
	}



	public void setServer_u_status(int server_u_status) {
		this.server_u_status = server_u_status;
	}



	public String getServer_u_stats_notify_year() {
		return server_u_stats_notify_year;
	}



	public void setServer_u_stats_notify_year(String server_u_stats_notify_year) {
		this.server_u_stats_notify_year = server_u_stats_notify_year;
	}



	public int getServer_u_stats_notify_month() {
		return server_u_stats_notify_month;
	}



	public void setServer_u_stats_notify_month(int server_u_stats_notify_month) {
		this.server_u_stats_notify_month = server_u_stats_notify_month;
	}



	public String getServer_u_stats_notify_half() {
		return server_u_stats_notify_half;
	}



	public void setServer_u_stats_notify_half(String server_u_stats_notify_half) {
		this.server_u_stats_notify_half = server_u_stats_notify_half;
	}



	public int getServer_u_system_mail_status() {
		return server_u_system_mail_status;
	}



	public void setServer_u_system_mail_status(int server_u_system_mail_status) {
		this.server_u_system_mail_status = server_u_system_mail_status;
	}



	public int getServer_u_halfmonth_status() {
		return server_u_halfmonth_status;
	}



	public void setServer_u_halfmonth_status(int server_u_halfmonth_status) {
		this.server_u_halfmonth_status = server_u_halfmonth_status;
	}



	public String getServer_u_last_login() {
		return server_u_last_login;
	}



	public void setServer_u_last_login(String server_u_last_login) {
		this.server_u_last_login = server_u_last_login;
	}
	
	

}
