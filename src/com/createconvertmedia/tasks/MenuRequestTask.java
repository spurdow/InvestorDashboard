package com.createconvertmedia.tasks;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.createconvertmedia.adapter.MenuListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Result;
import com.createconvertmedia.entry.KVEntry;
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MenuRequestTask extends AsyncTask<KVEntry<String,String> , String , String> {

	
	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG = MenuRequestTask.class.getSimpleName();
	
	private Context mContext;
	private MenuListAdapter mAdapter;
	private ProgressBar mProgress;
	public MenuRequestTask(Context applicationContext, MenuListAdapter adapter, ProgressBar large) {
		// TODO Auto-generated constructor stub
		this.mContext = applicationContext;
		this.mAdapter = adapter;
		this.mProgress = large;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		mProgress.setVisibility(View.VISIBLE);
		mProgress.setIndeterminate(true);
		super.onPreExecute();
	}
	
	@Override
	protected String doInBackground(KVEntry<String , String>... entries) {
		// TODO Auto-generated method stub
		String result= null;
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		for(Entry<String , String> entry : entries){
			Log.d(TAG, entry.getValue());
			nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(nvp));
			HttpResponse response = client.execute(post);
			
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) { 
	            Log.w(TAG, "Error " + statusCode + " while retrieving result from " + url); 
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
			if(client != null){
				client.close();
			}
		}
		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		mProgress.setVisibility(View.INVISIBLE);
		if(result != null){
			Gson gson = new Gson();
			Result json_result = gson.fromJson(result, Result.class);
			
			
			Log.d(TAG, "result status = " + json_result.getStatus() );
		}
		super.onPostExecute(result);
	}


	
	
	

}
