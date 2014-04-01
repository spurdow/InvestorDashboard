package com.createconvertmedia.investordashboard;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.User;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.fragment.DummyFragment;
import com.createconvertmedia.fragment.InvestorDashboardFragment;
import com.createconvertmedia.fragment.MenuListFragment;
import com.createconvertmedia.tasks.GcmRegisterTask;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class SlidingDashboard extends SlidingFragmentActivity{


	private static final String TAG = SlidingDashboard.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame	, new InvestorDashboardFragment()).commit();
		
		setBehindContentView(R.layout.menu_frame);
		
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.menu_frame, new MenuListFragment()).commit();
		
        SlidingMenu menu = this.getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.setSlidingEnabled(false);
  
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(!Utilities.isRegistrationKeyExist(this)){
	        User user = Utilities.getLoginDetails(this).getUser();
			KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
			KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "regid");
			KVEntry<String, String> user_id	 = new KVEntry<String, String>("user_id" , user.getServer_u_id()+"");
			new GcmRegisterTask(this).execute(android, what , user_id);
			Log.d(TAG, "Registration Key did not exists");
        }else{
        	Log.d(TAG, "Registration Key already exists");
        }
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getSupportMenuInflater().inflate(R.menu.sliding_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case android.R.id.home : toggle();break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void replace(Fragment frag){
/*		if(frag instanceof InvestorDashboardFragment){
			getSlidingMenu().setSlidingEnabled(false);
		}else{
			getSlidingMenu().setSlidingEnabled(true);
		}*/
		
		toggle();
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame, frag).commit();

	}
	
	
	
	
}
