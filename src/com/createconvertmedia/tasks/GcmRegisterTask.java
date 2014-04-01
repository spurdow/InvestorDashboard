package com.createconvertmedia.tasks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Result;
import com.createconvertmedia.entry.KVEntry;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class GcmRegisterTask extends AsyncTask<KVEntry<String , String> , String , String>{

	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG =GcmRegisterTask.class.getSimpleName();
	
	private Context mContext;
	private GoogleCloudMessaging gcm;
	private String regid;
	
	public GcmRegisterTask(Context mContext ) {
		super();
		this.mContext = mContext;
		gcm = GoogleCloudMessaging.getInstance(mContext);
	}



	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		String result = null;
		try {
			regid = gcm.register(Utilities.SENDER_ID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for(KVEntry<String , String> pair : arg0){
			pairs.add(new BasicNameValuePair(pair.getKey() , pair.getValue()));
		}
		pairs.add(new BasicNameValuePair("regid" , regid));
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
			final HttpResponse response = client.execute(post);
			final int statusCode = response.getStatusLine().getStatusCode();
			
			if(statusCode != HttpStatus.SC_OK){
				Log.w(TAG, "Error " + statusCode + " in url " + url);
				return null;
			}
			
			result = Utilities.getContent(response);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (client != null){
				client.close();
			}
		}
		
		
		return result;
	}



	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		if(result != null){
			Log.d(TAG, result);
			Gson gson = new Gson();
			Result result_fromjson = gson.fromJson(result, Result.class);
			if(result_fromjson.getStatus().equals("success")){
				Utilities.saveRegistrationKey(mContext , regid);
			}
		}
		super.onPostExecute(result);
	}
	
	
	
	
}
