package com.createconvertmedia.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.ProjectAdapter.Type;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.fragment.DummyFragment;
import com.createconvertmedia.fragment.ProjectFragment;

public class DashboardFragmentAdapter extends FragmentStatePagerAdapter{

	private static final String TAG = DashboardFragmentAdapter.class.getSimpleName();
	private List<SherlockListFragment> pages;
	private List<String> names;
	public DashboardFragmentAdapter(FragmentManager fm ) {
		super(fm);
		this.pages = new ArrayList<SherlockListFragment>();

		// TODO Auto-generated constructor stub
	}


	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		
		pages.add(ProjectFragment.newInstance(arg0 , names.get(arg0)));
		return pages.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return names.get(position)  ;
	}

	public void setNames(List<String> all) {
		// TODO Auto-generated method stub
		names = all;
	}


	

}
