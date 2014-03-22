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
import com.createconvertmedia.dbentity.DownloadHelper;
import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.entity.Pdf_downloadResult;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.NotifyUpdate;
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class DownloadRequestTask extends AsyncTask<KVEntry<String,String> , String , String>{

	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG = DownloadRequestTask.class.getSimpleName();

	
	private Context mContext;
	private NotifyUpdate notifier;
	public DownloadRequestTask(Context context){
		this.mContext = context;
	}
	
	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		String result = null;
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for(KVEntry<String, String> entry : arg0){
			pairs.add(new BasicNameValuePair(entry.getKey() , entry.getValue()));
		}
		
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
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
			//Log.d(TAG, result);
			Gson gson = new Gson();
			Pdf_downloadResult result_fromjson = gson.fromJson(result, Pdf_downloadResult.class);
			if(result_fromjson.getStatus().equals("success")){
				DownloadHelper helper = new DownloadHelper(mContext);
				for(Pdf_download download: result_fromjson.getPdfs()){
					helper.add(download);
				}
			}
			
			if(notifier != null){
				notifier.fire_update();
			}

		}
		super.onPostExecute(result);
	}

	public NotifyUpdate getNotifier() {
		return notifier;
	}

	public void setNotifier(NotifyUpdate notifier) {
		this.notifier = notifier;
	}

	
}
