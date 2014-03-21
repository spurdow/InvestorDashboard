package com.createconvertmedia.tasks;

import com.createconvertmedia.entry.KVEntry;

import android.content.Context;
import android.os.AsyncTask;

public class DownloadRequestTask extends AsyncTask<KVEntry<String,String> , String , String>{

	private Context mContext;
	
	
	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
