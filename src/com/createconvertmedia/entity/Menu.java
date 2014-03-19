package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Menu {
	/**
	 * the name is the menu name 
	 * for the menu listing
	 */
	@SerializedName("name")
	private String name;
	/**
	 * the post id will be the id on what 
	 * the server side will reply
	 */
	@SerializedName("post_id")
	private String post_id;
	/**
	 * if enabled then we have a list of tabs
	 */
	@SerializedName("isViewPagerEnabled")
	private boolean isViewPageEnabled;
	/**
	 * if view pager enabled
	 * then we will get some list
	 */
	@SerializedName("tab_list")
	private List<String> tab_list;
	/**
	 * id indicator if objects were notifed
	 */
	@SerializedName("notif")
	private int notif_no;
	
	
	public Menu() {
		super();
	}
	
	
	public Menu(String name, String post_id, boolean isViewPageEnabled,
			List<String> tab_list, int notif_no) {
		super();
		this.name = name;
		this.post_id = post_id;
		this.isViewPageEnabled = isViewPageEnabled;
		this.tab_list = tab_list;
		this.notif_no = notif_no;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public boolean isViewPageEnabled() {
		return isViewPageEnabled;
	}
	public void setViewPageEnabled(boolean isViewPageEnabled) {
		this.isViewPageEnabled = isViewPageEnabled;
	}
	public List<String> getTab_list() {
		return tab_list;
	}
	public void setTab_list(List<String> tab_list) {
		this.tab_list = tab_list;
	}
	public int getNotif_no() {
		return notif_no;
	}
	public void setNotif_no(int notif_no) {
		this.notif_no = notif_no;
	}
	
	
	
}
