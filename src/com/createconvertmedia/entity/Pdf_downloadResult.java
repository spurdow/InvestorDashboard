package com.createconvertmedia.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Pdf_downloadResult extends Result{
	
	@SerializedName("pdf")
	private List<Pdf_download> pdfs;
	
	

	public Pdf_downloadResult(List<Pdf_download> pdfs) {
		super();
		this.pdfs = pdfs;
	}

	public List<Pdf_download> getPdfs() {
		return pdfs;
	}

	public void setPdfs(List<Pdf_download> pdfs) {
		this.pdfs = pdfs;
	}
	
	
}
