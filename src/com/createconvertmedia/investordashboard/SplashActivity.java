package com.createconvertmedia.investordashboard;

import java.util.ArrayList;
import java.util.List;


import com.createconvertmedia.commons.AfterTextChanged;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.ISwipeGesture;
import com.createconvertmedia.tasks.LoginRequestTask;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;


import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;

import static com.createconvertmedia.commons.Utilities.*;

public class SplashActivity extends Activity implements OnTouchListener{
	
	private final static String TAG = "SplashScreen";

	private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	
	private GestureDetector gesture;

	private Point last_point;
	
	private RelativeLayout child;
	
	private boolean error = true;
	
	//public GoogleCloudMessaging gcm;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_splash_screen);
		

		if(checkPlayServices()){
			LoginResult lResult = Utilities.getLoginDetails(this);
			
			
			if( lResult != null && lResult.getStatus()!= null && lResult.getStatus().equals("success")){
				Intent i = new Intent(this , SlidingDashboard.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
			}
			
			gesture = new GestureDetector(new GestureOpenListener());
			
			child = (RelativeLayout) findViewById(R.id.splashscreen_child_layout);
			child.setOnTouchListener(this);
			
			last_point = new Point();
				
		}
		
	}


	 /*
     *  Fling detection
     */
    private final class GestureOpenListener extends SimpleOnGestureListener implements ISwipeGesture{
    	private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;
        
        
      
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			boolean result = true;
			
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                	
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            swipeRight();
                        } else {
                            swipeLeft();
                        }
                        
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            swipeDown();
                        } else {
                            swipeUp();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
			
			return result;
		}


		@Override
		public void swipeLeft() {
			// TODO Auto-generated method stub
			
			
			Log.d(TAG, "Swipe Left");
		}


		@Override
		public void swipeRight() {
			// TODO Auto-generated method stub
			Log.d(TAG, "Swipe Right");
		}


		@Override
		public void swipeDown() {
			// TODO Auto-generated method stub
			Log.d(TAG, "Swipe Down");	
		}


		
		@Override
		public void swipeUp() {
			// TODO Auto-generated method stub
			error = false;
			LayoutInflater inflater = LayoutInflater.from(SplashActivity.this);
			View dialogview = inflater.inflate(R.layout.login_layout, null);
			
			 AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(SplashActivity.this);
			 dialogbuilder.setView(dialogview);
			 final AlertDialog dialog = dialogbuilder.create();
			 
			Button login = (Button) dialogview.findViewById(R.id.btn_login);
			
			final EditText username = (EditText) dialogview.findViewById(R.id.txt_uname);
			final EditText password = (EditText) dialogview.findViewById(R.id.txt_password_login);
			
			final TextView username_error = (TextView) dialogview.findViewById(R.id.txt_uname_error);
			final TextView password_error = (TextView) dialogview.findViewById(R.id.txt_password_login_error);
			
			username.addTextChangedListener(new AfterTextChanged(){

				@Override
				public void abstract_afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					if(!isValidString(s.toString())){
						error = true;
						username_error.setText("Username is empty");
					}else{
						error = false;
						username_error.setText("");
					}
				}
				
			});
			
			password.addTextChangedListener(new AfterTextChanged(){

				@Override
				public void abstract_afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					if(!isValidString(s.toString()) || !isValidPassword(s.toString())){
						error = true;
						password_error.setText("Password must be greater than 4 characters");
					}else{
						error = false;
						password_error.setText("");
					}
				}
				
				
			});
			   
			login.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					List<String> list = new ArrayList<String>();
					
					list.add(username.getText().toString());
					list.add(password.getText().toString());
					
					for(String str : list){
						if(!isValidString(str)){
							error = true;
							break;
						}
					}
					
					if(!error){
						
						/**
						 * Create a login Task here!
						 */
						KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
						KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "login");
						KVEntry<String, String> username	 = new KVEntry<String, String>("username" , list.get(0));
						KVEntry<String, String> password	 = new KVEntry<String, String>("password" , list.get(1));
						LoginRequestTask t = new LoginRequestTask(SplashActivity.this);
						t.setParentDialog(dialog);
						t.execute(android, what, username, password);
						
						/*
						 *  get the registration id if no reg id registered on the device
						 */
						
					}else{
						Log.d(TAG, "Sorry theres something wrong with the inputs.");
						AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(SplashActivity.this);
						 // dialogbuilder.setTitle("Login");
						 // dialogbuilder.setIcon(R.drawable.ic_launcher);
						 dialogbuilder.setTitle("Error").setMessage("Please fill all fields")
						 .setIcon(android.R.drawable.ic_delete);
						 AlertDialog dialog = dialogbuilder.create();
						 //dialog.set
						 dialog.setButton(Dialog.BUTTON_POSITIVE, "Ok", new Dialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								arg0.dismiss();
							}
						});
						   
						 dialog.show();
					}
						
				}
				   
			 });
			dialog.show();
			Log.d(TAG, "Swipe Up");
		}
    	
    }
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		// pass the motionevent to touchevent of gesture
		gesture.onTouchEvent(arg1);
		//get the last point
		last_point.x = (int) arg1.getX();
		last_point.y = (int) arg1.getY();
		
		Log.d(TAG, last_point.toString());
		return true;
	}
	
	/**
	 * Check the device to make sure it has the Google Play Services APK. If
	 * it doesn't, display a dialog that allows users to download the APK from
	 * the Google Play Store or enable it in the device's system settings.
	 */
	private boolean checkPlayServices() {
	    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    if (resultCode != ConnectionResult.SUCCESS) {
	        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	            GooglePlayServicesUtil.getErrorDialog(resultCode, this,
	                    PLAY_SERVICES_RESOLUTION_REQUEST).show();
	            
	           
	        } else {
	            Log.i(TAG, "This device is not supported.");
	            finish();
	        }
	        return false;
	      
	    }
	    return true;
	    
	}

}
