package com.createconvertmedia.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;

import com.createconvertmedia.entity.Investor;
import com.createconvertmedia.entity.LoginResult;
import com.google.gson.Gson;



import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import android.view.View;

public class Utilities {

	
	public final static String HOST = "http://ccinvestors.ngrok.com/ccinvestors";
	
	public final static String ANDROID_FOLDER = "android";
	
	public final static String CLIENT = "android_client";
	
	public final static String WHAT = "what";
	
	private static final String TAG = "Utilities";
	
	/** 
	 * static bitmap downloader
	 */
	public static Bitmap downloadBitmap(String url) {
	    final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
	    final HttpGet getRequest = new HttpGet(url);

	    try {
	        HttpResponse response = client.execute(getRequest);
	        final int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != HttpStatus.SC_OK) { 
	            Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url); 
	            return null;
	        }
	        
	        final HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            InputStream inputStream = null;
	            try {
	                inputStream = entity.getContent(); 
	                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
	                return bitmap;
	            } finally {
	                if (inputStream != null) {
	                    inputStream.close();  
	                }
	                entity.consumeContent();
	            }
	        }
	    } catch (Exception e) {
	        // Could provide a more explicit error message for IOException or IllegalStateException
	        getRequest.abort();
	        Log.w("ImageDownloader", "Error while retrieving bitmap from " + url + " " + e.toString());
	    } finally {
	        if (client != null) {
	            client.close();
	        }
	    }
	    return null;
	}	
	
	/**
	 *  getting http-response as string
	 */
	public static String getContent(HttpResponse response) throws ParseException, IOException{
		String result = "";
		InputStream is = null;
		final HttpEntity entity = response.getEntity();
		
		if(entity == null){
			Log.w(TAG, "Failed to get entity");
			return null;
		}
		
		is = entity.getContent();
				
		try {
			
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    is, "iso-8859-1"), 8);
	            StringBuilder sb = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
            
            is.close();
            result = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        } finally{
        	/**
        	 *  safe removal of inputstream
        	 */
        	if(is != null){
        		is.close();
        	}
        	/**
        	 *  release all allocated resources
        	 */
        	entity.consumeContent();
        }
		
		
		return result;
	}
	
	public enum AlertType{
		SUCCESS,
		ERROR,
		WARNING
	}
	/**
	 * Message Builder
	 * @param context
	 * @param aType
	 * @param message
	 * @param title
	 * @param icon
	 * @param inflatedView
	 * @return
	 */
	protected static AlertDialog.Builder alert(Context context, AlertType aType , String message , String title , int icon, View inflatedView ){
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if( inflatedView != null ){
			builder.setView(inflatedView);
			/*
			 * add some text message area
			 * and action onClick
			 */
		}else{
			builder.setTitle(title).setMessage(message).setIcon(icon);
			builder.setPositiveButton("Okay", new OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
				
			});
		}
		
		return builder;
	}
	/**
	 * Success Message Builder
	 * @param context
	 * @param message
	 * @return
	 */
	public static AlertDialog.Builder success(Context context, String message){
		return alert(context , AlertType.SUCCESS , message, "Success" , android.R.drawable.checkbox_on_background , null);
	}
	/**
	 * Error Message Builder
	 * @param context
	 * @param message
	 * @return
	 */
	public static AlertDialog.Builder error(Context context , String message){
		return alert(context , AlertType.ERROR , message, "Error" , android.R.drawable.checkbox_off_background , null);
	}
	/**
	 * launch keys
	 * @author Admin
	 *
	 */
	public enum LaunchKey{
		
		APP_LAUNCH("app_launch"),
		DASHBOARD_LAUNCH("investor_dashboard_launch"),
		TRANSACTION_LAUNCH("transaction_launch"),
		DOWNLOAD_LAUNCH("download_launch"),
		INVESTOR_UPDATES_LAUNCH("investor_updates_launch"),
		MESSAGES_LAUNCH("message_launch"),
		
		;
		
		private String key;
		private LaunchKey(String key){
			this.key = key;
		}
		public String getKey(){return key;}
	}
	
	/**
	 * check whether it is first launched
	 * @param context
	 * @return
	 */
	public static boolean isAppFirstLaunched(Context context){
		return isFirstLaunched(context , LaunchKey.APP_LAUNCH);
	}
	/**
	 * check whether key is first launched
	 * in preferences
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean isFirstLaunched(Context context, LaunchKey key){
		SharedPreferences pref = getPreferences(context);
		if(!pref.contains(key.getKey())){
			SharedPreferences.Editor editor = pref.edit();
			editor.putBoolean(key.getKey(), true).commit();
			return true;
		}
		return false;
	}
	
	
	/**
	 * saving login details for investor
	 * @param context
	 * @param investor
	 */
	public static void saveLoginDetails(Context context , LoginResult lResult){
		SharedPreferences shared = getPreferences(context);
		SharedPreferences.Editor editor = shared.edit();
		Gson gson = new Gson();
		String to_json = gson.toJson(lResult);
		editor.putString("LoginResult", to_json);
		editor.commit();
	}
	/**
	 * getting login information of investors saved in preferences
	 * @param context
	 * @return
	 */
	public static LoginResult getLoginDetails(Context context){
		SharedPreferences shared = getPreferences(context);
		Gson gson = new Gson();
		String from_json = shared.getString("LoginResult", "");
		LoginResult result = gson.fromJson(from_json, LoginResult.class);
		return result;
	}
	
	/**
	 *  getting shared preferences
	 */
	
	public static SharedPreferences getPreferences(Context context){
		return context.getSharedPreferences(com.createconvertmedia.investordashboard.SplashActivity.class.getSimpleName(), Context.MODE_PRIVATE);
	}
	
	/**
	 *  validate password against confirm password
	 */
	public static boolean isValidPassword2Password(String p1, String p2){
		return p1.equals(p2);
	}
	
	/**
	 *  validate username 
	 */
	public static boolean isValidUsername(String str_sequence){
		return str_sequence.length() > 0 && str_sequence.length() < 100;
	}
	
	/**
	 *  validate password
	 */
	public static boolean isValidPassword(String str_sequence){
		return str_sequence.length() > 4 && str_sequence.length() < 50;
	}
	
	/**
	 *  validate empty strings
	 */
	@SuppressLint("NewApi")
	public static boolean isValidString(String str_sequence){
		if(str_sequence == null || str_sequence.equals("")  || str_sequence.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	/**
	 *  validate email address
	 */
	public static boolean isValidEmail(String email){
		Pattern pattern;
		Matcher matcher;
	         String regExpn =
	             "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
	                 +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
	                   +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
	                   +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
	
	     CharSequence inputStr = email;
	
	     pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
	     matcher = pattern.matcher(inputStr);
	
	     if(matcher.matches())
	        return true;
	     else
	        return false;
	}
	
	
}
