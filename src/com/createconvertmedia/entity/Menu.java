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
	 * id indicator if objects were notified
	 */
	@SerializedName("notif")
	private int notif_no;
	
	
	public Menu(String name) {
		this.name = name;
		this.notif_no = 0;
	}
	
	
	public Menu(String name,  int notif_no) {
		super();
		this.name = name;
		this.notif_no = notif_no;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getNotif_no() {
		return notif_no;
	}
	public void setNotif_no(int notif_no) {
		this.notif_no = notif_no;
	}
	
	
	
}
