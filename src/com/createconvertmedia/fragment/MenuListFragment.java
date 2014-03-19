package com.createconvertmedia.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.MenuListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Menu;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.tasks.MenuRequestTask;



public class MenuListFragment extends SherlockListFragment{

	
	private MenuListAdapter adapter;
	
	private ProgressBar large;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		RelativeLayout view = (RelativeLayout)inflater.inflate(R.layout.menu_layout, container , false );
		large = (ProgressBar) view.findViewById(R.id.menu_progressbar);
		return view;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		adapter = new MenuListAdapter(this.getActivity().getApplicationContext() , new ArrayList<Menu>());
		setListAdapter(adapter);
		
		KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
		KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "menu");
		
		new MenuRequestTask(this.getActivity().getApplicationContext() , adapter , large).execute(android,what);
		
		
	}
	
	
	
	
}
