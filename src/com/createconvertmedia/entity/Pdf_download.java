package com.createconvertmedia.entity;

import com.google.gson.annotations.SerializedName;

public class Pdf_download {
	
	/**
	Pdf_download Table
	id 									long integer primary key ai
	server_id 							long
	server_pdf_title 					text
	server_pdf_file_name 				text
	server_pdf_original_name 			text
	server_created 						text
	server_modified 					text
	server_status 						integer
	 */
	
	public final static class DatabaseKey{
		public String ID = "id";
		public String SERVER_ID = "server_id";
		public String SERVER_PDF_TITLE = "server_pdf_title";
		public String SERVER_PDF_FILE_NAME = "server_pdf_file_name";
		public String SERVER_PDF_ORIGINAL_NAME = "server_pdf_original_name";
		public String SERVER_CREATED = "server_created";
		public String SERVER_MODIFIED = "server_modified";
		public String SERVER_STATUS = "server_status";
		
		public String TABLE = "Pdf_download";
		public String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
				+ SERVER_ID + " INTEGER UNIQUE , " + SERVER_PDF_TITLE + " TEXT , " + SERVER_PDF_FILE_NAME + " TEXT, "
				+ SERVER_PDF_ORIGINAL_NAME + " TEXT , " + SERVER_CREATED + " TEXT , " + SERVER_MODIFIED + " TEXT , "
				+ SERVER_STATUS + " INTEGER );";
		public String INDEX = "CREATE INDEX " + TABLE + "_" + SERVER_ID + "x ON " + TABLE + "(" + SERVER_ID + ");"   ;
		
		public String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;
	}
	
	private long c_id;
	
	@SerializedName("id")
	private long server_id;
	
	@SerializedName("pdf_title")
	private String server_pdf_title;
	
	@SerializedName("pdf_file_name")
	private String server_pdf_file_name;
	
	@SerializedName("pdf_original_name")
	private String server_pdf_original_name;
	
	@SerializedName("created")
	private String server_created;
	
	@SerializedName("modified")
	private String server_modified;
	
	@SerializedName("status")
	private String server_status;
	
	

	public Pdf_download(long c_id, long server_id, String server_pdf_title,
			String server_pdf_file_name, String server_pdf_original_name,
			String server_created, String server_modified, String server_status) {
		super();
		this.c_id = c_id;
		this.server_id = server_id;
		this.server_pdf_title = server_pdf_title;
		this.server_pdf_file_name = server_pdf_file_name;
		this.server_pdf_original_name = server_pdf_original_name;
		this.server_created = server_created;
		this.server_modified = server_modified;
		this.server_status = server_status;
	}

	public Pdf_download() {
		// TODO Auto-generated constructor stub
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public long getServer_id() {
		return server_id;
	}

	public void setServer_id(long server_id) {
		this.server_id = server_id;
	}

	public String getServer_pdf_title() {
		return server_pdf_title;
	}

	public void setServer_pdf_title(String server_pdf_title) {
		this.server_pdf_title = server_pdf_title;
	}

	public String getServer_pdf_file_name() {
		return server_pdf_file_name;
	}

	public void setServer_pdf_file_name(String server_pdf_file_name) {
		this.server_pdf_file_name = server_pdf_file_name;
	}

	public String getServer_pdf_original_name() {
		return server_pdf_original_name;
	}

	public void setServer_pdf_original_name(String server_pdf_original_name) {
		this.server_pdf_original_name = server_pdf_original_name;
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

	public String getServer_status() {
		return server_status;
	}

	public void setServer_status(String server_status) {
		this.server_status = server_status;
	}
	
	
}
