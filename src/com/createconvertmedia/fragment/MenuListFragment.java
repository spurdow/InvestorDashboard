package com.createconvertmedia.fragment;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.MenuListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Investor;
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entity.Menu;
import com.createconvertmedia.entity.User;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.investordashboard.SlidingDashboard;
import com.createconvertmedia.investordashboard.SplashActivity;
import com.createconvertmedia.tasks.MenuRequestTask;



public class MenuListFragment extends SherlockListFragment implements OnItemClickListener{

	
	private MenuListAdapter adapter;
	
	private ProgressBar large;
	
	private UpdateReceiver mreciever;
	
	private static final String TAG = MenuListFragment.class.getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		RelativeLayout view = (RelativeLayout)inflater.inflate(R.layout.menu_layout, container , false );
		large = (ProgressBar) view.findViewById(R.id.menu_progressbar);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		ArrayList<Menu> menu = new ArrayList<Menu>();
		
		menu.add(new Menu("Investor Dashboard"));
		menu.add(new Menu("Share Purchase Transaction"));
		menu.add(new Menu("Downloads"));
		menu.add(new Menu("Logout"));
		
		View headerView = LayoutInflater.from(this.getActivity().getApplicationContext()).inflate(R.layout.my_account, null);
		
		final TextView name = (TextView) headerView.findViewById(R.id.ma_name);
		final TextView username = (TextView) headerView.findViewById(R.id.ma_username);
		final TextView email = (TextView) headerView.findViewById(R.id.ma_email);
		final TextView country = (TextView) headerView.findViewById(R.id.ma_country);
		final TextView state_province = (TextView) headerView.findViewById(R.id.ma_state_province);
		final TextView city = (TextView) headerView.findViewById(R.id.ma_city);
		final TextView address = (TextView) headerView.findViewById(R.id.ma_address);
		final TextView zip_code = (TextView) headerView.findViewById(R.id.ma_zip_code);
		final TextView phone = (TextView) headerView.findViewById(R.id.ma_phone);
		
		LoginResult lResult = Utilities.getLoginDetails(this.getActivity().getApplicationContext());
		
		Investor investor = lResult.getInvestor();
		User user = lResult.getUser();
		
		name.setText(user.getServer_u_name());
		username.setText(user.getServer_u_username());
		email.setText(user.getServer_u_email());
		country.setText(investor.getServer_i_country());
		state_province.setText(investor.getServer_i_state());
		city.setText(investor.getServer_i_city());
		address.setText(investor.getServer_i_address());
		zip_code.setText(investor.getServer_i_zip());
		phone.setText(investor.getServer_i_phone());
		
		getListView().addHeaderView(headerView);
		getListView().setHeaderDividersEnabled(true);
		getListView().setOnItemClickListener(this);
		
		adapter = new MenuListAdapter(this.getActivity().getApplicationContext() ,menu);
		
		mreciever = new UpdateReceiver();
		
		setListAdapter(adapter);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		case 1 : ((SlidingDashboard) this.getActivity()).replace(new InvestorDashboardFragment()); break;
		case 2 : ((SlidingDashboard) this.getActivity()).replace(new TransactionFragment()); break;
		case 3 : ((SlidingDashboard) this.getActivity()).replace(new DownloadFragment()); break;
		case 4 : ((SlidingDashboard) this.getActivity()).toggle();
				Utilities.removeLoginDetails(getActivity());
				Intent i = new Intent(getActivity() , SplashActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
				getActivity().startActivity(i);
		break;
		}
		
		
	}
	
	private class UpdateReceiver extends BroadcastReceiver{
		
		

		/*
		 *  local broadcast reciever
		 */
		@Override
		public void onReceive(final Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			int id = intent.getIntExtra("not_id", -1);
			Menu m = adapter.getObject(id);
			m.setNotif_no(m.getNotif_no() + 1);
			adapter.notifyDataSetChanged();
			Log.d(TAG, "updating projects...");
			
		}
		
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		LocalBroadcastManager.getInstance(this.getActivity()).unregisterReceiver(mreciever);
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		LocalBroadcastManager.getInstance(this.getActivity()).registerReceiver(mreciever, new IntentFilter("new_project"));
		super.onResume();
	}
	
	
	
	
}
