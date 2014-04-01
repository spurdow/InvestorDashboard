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

import com.commonsware.cwac.merge.MergeAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.dbentity.ShareHelper;
import com.createconvertmedia.dbentity.WithdrawalHelper;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.entity.TransactionResult;
import com.createconvertmedia.entity.Withdrawal;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.INotifyUpdate;
import com.google.gson.Gson;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

public class TransactionRequestTask extends AsyncTask<KVEntry<String , String> , String , String>{

	
	private final static String url = Utilities.HOST +"/"+Utilities.ANDROID_FOLDER+"/server_response.php";
	private static final String TAG = TransactionRequestTask.class.getSimpleName();
	private Context mContext;
	private MergeAdapter merge;
	
	
	private INotifyUpdate notify;
	
	public TransactionRequestTask(Context context, MergeAdapter merge){
		this.mContext = context;
		this.merge = merge;
	}
	
	
	
	@Override
	protected String doInBackground(KVEntry<String, String>... arg0) {
		// TODO Auto-generated method stub
		String result = null;
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		
		for(KVEntry<String , String> entry : arg0){
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
			if(client != null || null != client){ // <--- LOLLLLLL
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
			
			TransactionResult result_fromjson = gson.fromJson(result, TransactionResult.class);
			final ShareHelper sHelper = new ShareHelper(mContext);
			for(Share share : result_fromjson.getShares()){
				sHelper.add(share);
			}
			final WithdrawalHelper wHelper = new WithdrawalHelper(mContext);
			for(Withdrawal withdraw : result_fromjson.getWithdrawals()){
				wHelper.add(withdraw);
			}
			
			if(notify != null){
				notify.fire_update();
			}
		}
		super.onPostExecute(result);
	}

	public INotifyUpdate getNotify() {
		return notify;
	}

	public void setNotify(INotifyUpdate notify) {
		this.notify = notify;
	}
	
}
