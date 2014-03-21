package com.createconvertmedia.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.DownloadListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.NotifyUpdate;
import com.createconvertmedia.investordashboard.R;

public class DownloadFragment extends SherlockListFragment{

	private ProgressBar pBar;
	private DownloadListAdapter adapter;
	private NotifyUpdate notify;
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.content_layout, container , false);
		pBar = (ProgressBar) v.findViewById(R.id.content_progressbar);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
		KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "transaction");
		
		super.onActivityCreated(savedInstanceState);
	}

	public NotifyUpdate getNotify() {
		return notify;
	}

	public void setNotify(NotifyUpdate notify) {
		this.notify = notify;
	}
	
	
	
}
