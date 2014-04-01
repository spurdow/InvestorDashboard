package com.createconvertmedia.investordashboard;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.dbentity.ProjectHelper;
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entity.Project;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import static com.createconvertmedia.commons.Utilities.*;

public class GcmIntentService extends IntentService {
	private static final String TAG = "GcmIntentService";
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;

    public GcmIntentService() {
        super("GcmIntentService");
    }
    
    

    @Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}



	@Override
    protected void onHandleIntent(Intent intent) {
		mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {  // has effect of unparcelling Bundle
            /*
             * Filter messages based on message type. Since it is likely that GCM
             * will be extended in the future with new message types, just ignore
             * any message types you're not interested in, or that you don't
             * recognize.
             */
            if (GoogleCloudMessaging.
                    MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
            	Log.d(TAG , "error");
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_DELETED.equals(messageType)) {
            	Log.d(TAG , "deleted");
            // If it's a regular GCM message, do some work.
            } else if (GoogleCloudMessaging.
                    MESSAGE_TYPE_MESSAGE.equals(messageType)) {
            	Log.d(TAG , "message");
            	/**
            	 *  generate notification only if notify is not null 
            	 *  and notify is true
            	 */
            	 Log.i(TAG, "Received: " + extras.toString());
            	if(extras.getString("notify") != null && Boolean.valueOf(extras.getString("notify"))){
	            	if(extras.getString("notification_id") != null){
	            		generateNotification(Integer.valueOf(extras.getString("notification_id")) , extras);
	            	}
            	}
               // Log.i(TAG, "Received: " + extras.toString());
            }
        }
        
        // Release the wake lock provided by the WakefulBroadcastReceiver.
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }
    
	/**
	 * the generality of generating notification
	 * @param notification_id
	 * @param extras
	 */
	private void generateNotification(int notification_id , Bundle extras){
		switch(notification_id){
		case NOTIF_DASHBOARD: 
				generateInvestorDashboard(notification_id , extras);
			break;
		case NOTIF_HISTORY	: 
				generateTransactionHistory(notification_id , extras);
			break;
		case NOTIF_DOWNLOADS: 
				generateDownloads(notification_id , extras);
			break;
		default: assert false; break;
		}
	}
	
	private void generateInvestorDashboard(int notification_id , Bundle extras){
		/*Project project ;*/

		Gson gson = new Gson();
		Type type_class = new TypeToken<ArrayList<Project>>(){}.getType();
		List<Project> projects = gson.fromJson(extras.get("projects").toString(),type_class );
		final ProjectHelper helper = new ProjectHelper(this.getApplicationContext());
		for(Project referenceProject : projects){
			final Project p = helper.getSpecificProject(referenceProject);
			if( p == null){
				long id = helper.add(referenceProject);
				/*
				 *  send broadcast to projects
				 */
				LoginResult result = Utilities.getLoginDetails(getApplicationContext());
				List<String> names = result.getNames();
				boolean canAdd= true;
				for(String name : names){
					if(name.equals(referenceProject.getServer_name())){
						canAdd = false;
					}
				}
				if(canAdd){
					
					names.add(referenceProject.getServer_name());
					result.setNames(names);
					Utilities.saveLoginDetails(getApplicationContext(), result);
					Log.d(TAG, "Added New Title = " + referenceProject.getServer_name());
				}
				
				Intent i = new Intent("new_project");
				i.putExtra("project_id", id);
				i.putExtra("not_id", notification_id);
				LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(i);
				Log.d(TAG, "adding new project");
			}else{
				helper.update(p.getId(), p);
				Log.d(TAG, "updating new project");
			}
		}	
		

		
		if(Boolean.valueOf(extras.getString("notify"))){
			Intent intent = new Intent(this , SplashActivity.class);
			PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
    		/*
    		 *  notification side
    		 */
            final NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle("Investor Dashboard")
            .setContentText("Project Updates");
            
            final Notification notif = mBuilder.build();
            notif.flags |= Notification.FLAG_AUTO_CANCEL;
            
            mBuilder.setContentIntent(contentIntent);
            mBuilder.setAutoCancel(true);
            mNotificationManager.notify(notification_id, notif);
		}
	}
	
	private void generateTransactionHistory(int notification_id , Bundle extras){
		if(Boolean.valueOf(extras.getString("notify"))){
			
		}
	}
	
	private void generateDownloads(int notification_id , Bundle extras){
		if(Boolean.valueOf(extras.getString("notify"))){
			
		}		
	}
}