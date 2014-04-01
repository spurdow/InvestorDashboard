package com.createconvertmedia.fragment;


import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.createconvertmedia.adapter.DashboardFragmentAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.investordashboard.SlidingDashboard;
import com.createconvertmedia.view.PagerSlidingTabStrip;


public class InvestorDashboardFragment extends SherlockFragment {
	
	private ViewPager pager;
	private PagerSlidingTabStrip tabs;
	private DashboardFragmentAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setHasOptionsMenu(true);
		View v = inflater.inflate(R.layout.dashboard_layout, container , false);
		pager = (ViewPager) v.findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		adapter = new DashboardFragmentAdapter(((SlidingDashboard)getActivity()).getSupportFragmentManager());
		List<String> names = Utilities.getLoginDetails(getActivity()).getNames();
		adapter.setNames(names);
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		

		super.onActivityCreated(savedInstanceState);
	}



	


	
}
