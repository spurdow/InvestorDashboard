package com.createconvertmedia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.DownloadListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.dbentity.DownloadHelper;
import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.NotifyUpdate;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.tasks.DownloadRequestTask;

public class DownloadFragment extends SherlockListFragment implements NotifyUpdate{

	private ProgressBar pBar;
	private DownloadListAdapter adapter;
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.content_layout, container , false);
		pBar = (ProgressBar) v.findViewById(R.id.content_progressbar);
		pBar.setVisibility(View.VISIBLE);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		List<Pdf_download> downloads = new ArrayList<Pdf_download>();
		adapter = new DownloadListAdapter(getActivity() , downloads);
		setListAdapter(adapter);
		
		if(Utilities.isFirstLaunched(this.getActivity(), Utilities.LaunchKey.DOWNLOAD_LAUNCH)){
			KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
			KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "download");
			DownloadRequestTask downloadTask = new DownloadRequestTask(getActivity());
			downloadTask.setNotifier(this);
			downloadTask.execute(android , what);
			
		}else{
			fire_update();
		}
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void fire_update() {
		// TODO Auto-generated method stub
		DownloadHelper helper = new DownloadHelper(getActivity());
		for(Pdf_download d : helper.getAll()){
			adapter.add(d);
		}
		
		pBar.setVisibility(View.INVISIBLE);
	}
	
	
	
}
