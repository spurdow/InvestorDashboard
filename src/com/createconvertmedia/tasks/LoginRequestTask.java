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
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class LoginRequestTask extends AsyncTask<KVEntry<String,String> , String , String>{
	
	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG = LoginRequestTask.class.getSimpleName();

	private Context mContext;
	public LoginRequestTask(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}


	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		String result = null;
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		for(KVEntry<String, String> entry : arg0){
			nvp.add(new BasicNameValuePair(entry.getKey() , entry.getValue()));
		}
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpPost post = new HttpPost(url);
		
		try {
			post.setEntity(new UrlEncodedFormEntity(nvp));
			
			HttpResponse response = client.execute(post);
			final int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode != HttpStatus.SC_OK){
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
		if(result != null){
			Gson gson = new Gson();
			Result from_json = gson.fromJson(result, Result.class);
			Log.d(TAG, "result = " +  from_json );
		}
		super.onPostExecute(result);
	}
	
	

}
