package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class User  {
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
	
	@SerializedName("id")
	private long server_u_id ;
	
	@SerializedName("name")
	private String server_u_name;
	
	@SerializedName("username")
	private String server_u_username;
	
	@SerializedName("email")
	private String server_u_email;
	
	@SerializedName("password")
	private String server_u_password;
	
	@SerializedName("role")
	private String server_u_role;
	
	@SerializedName("status")
	private int server_u_status;
	
	@SerializedName("stats_notify_year")
	private String server_u_stats_notify_year;
	
	@SerializedName("stats_notify_month")
	private int server_u_stats_notify_month ;
	
	@SerializedName("stats_notify_half")
	private String server_u_stats_notify_half;
	
	@SerializedName("system_mail_status")
	private int server_u_system_mail_status;
	
	@SerializedName("halfmonth_status")
	private int server_u_halfmonth_status;
	
	@SerializedName("last_login")
	private String server_u_last_login;
	
	
	
	public User(long server_u_id, String server_u_name,
			String server_u_username, String server_u_email,
			String server_u_password, String server_u_role,
			int server_u_status, String server_u_stats_notify_year,
			int server_u_stats_notify_month, String server_u_stats_notify_half,
			int server_u_system_mail_status, int server_u_halfmonth_status,
			String server_u_last_login) {
		super();
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
