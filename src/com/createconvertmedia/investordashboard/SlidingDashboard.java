package com.createconvertmedia.investordashboard;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;
import com.createconvertmedia.fragment.DummyFragment;
import com.createconvertmedia.fragment.MenuListFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class SlidingDashboard extends SlidingFragmentActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_frame);
		
/*		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame	, new DummyFragment()).commit();
		*/
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
  
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
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
		toggle();
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame, frag).commit();
	}
	
	
	
	
}
