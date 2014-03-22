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
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entity.Result;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.investordashboard.SlidingDashboard;
import com.google.gson.Gson;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

public class LoginRequestTask extends AsyncTask<KVEntry<String,String> , String , String>{
	
	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG = LoginRequestTask.class.getSimpleName();

	private Context mContext;
	private ProgressDialog dialog;
	public LoginRequestTask(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	
	

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		dialog = new ProgressDialog(mContext);
		dialog.setIndeterminate(true);
		dialog.setMessage("Please wait while we check your credentials");
		dialog.show();
		super.onPreExecute();
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
		dialog.dismiss();
		return result;
	}


	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		if(result != null){
			Gson gson = new Gson();;
			LoginResult result_fromjson = gson.fromJson(result, LoginResult.class);
			if(result_fromjson.getStatus().equals("success")){
				
				Utilities.saveLoginDetails(mContext, result_fromjson);
				Intent i = new Intent(mContext , SlidingDashboard.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
				mContext.startActivity(i);
				
			}else{
				AlertDialog.Builder builder = Utilities.error(mContext, "Username or Password is incorrect");
				final AlertDialog alert = builder.create();
				alert.show();
				
			}
		}
		super.onPostExecute(result);
	}
	
	

}
