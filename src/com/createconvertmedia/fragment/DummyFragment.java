package com.createconvertmedia.fragment;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.investordashboard.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class DummyFragment extends SherlockListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return (LinearLayout)inflater.inflate(R.layout.content_layout,container , false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
}
