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
import com.createconvertmedia.dbentity.ProjectHelper;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.entity.ProjectResult;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.INotifyUpdate;
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class ProjectRequestTask extends AsyncTask<KVEntry<String , String> , String , String>{

	private final static String TAG = ProjectRequestTask.class.getSimpleName();
	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private Context mContext;
	private INotifyUpdate mNotifier;
	
	public ProjectRequestTask(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		String result = null;
		for(KVEntry<String , String> entry : arg0){
			pairs.add(new BasicNameValuePair(entry.getKey() , entry.getValue()));
		}
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse response = client.execute(post);
			
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
			Log.d(TAG , result );
		}
		super.onPostExecute(result);
	}

	public void setNotifyUpdate(INotifyUpdate notifier) {
		// TODO Auto-generated method stub
		mNotifier = notifier;
	}

}
