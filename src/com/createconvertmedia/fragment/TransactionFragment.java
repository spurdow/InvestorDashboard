package com.createconvertmedia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.commonsware.cwac.merge.MergeAdapter;
import com.createconvertmedia.adapter.ShareListAdapter;
import com.createconvertmedia.adapter.WithdrawListAdapter;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.commons.Utilities.LaunchKey;
import com.createconvertmedia.dbentity.ShareHelper;
import com.createconvertmedia.dbentity.WithdrawalHelper;
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.entity.User;
import com.createconvertmedia.entity.Withdrawal;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.NotifyUpdate;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.tasks.TransactionRequestTask;


public class TransactionFragment extends SherlockListFragment implements NotifyUpdate{

	private static final String TAG = TransactionFragment.class.getSimpleName();
	private WithdrawListAdapter wAdapter;
	private ShareListAdapter sAdapter;
	private ProgressBar progress;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.content_layout, container , false);
		progress = (ProgressBar) view.findViewById(R.id.content_progressbar);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		MergeAdapter merge = new MergeAdapter();
		

		List<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
		wAdapter =  new WithdrawListAdapter(this.getActivity().getApplicationContext() , withdrawals);
		
		List<Share> shares = new ArrayList<Share>();
		sAdapter = new ShareListAdapter(this.getActivity().getApplicationContext() ,shares);
		
		merge.addView(addTitleView("Transaction History"));
		merge.addAdapter(sAdapter);
		merge.addView(addTitleView("Withdrawal History"));
		merge.addAdapter(wAdapter);
		
		setListAdapter(merge);
		if(Utilities.isFirstLaunched(getActivity(), LaunchKey.TRANSACTION_LAUNCH)){
			Log.d(TAG, Utilities.isFirstLaunched(getActivity(), LaunchKey.TRANSACTION_LAUNCH) +" = ???");
			TransactionRequestTask task = new TransactionRequestTask(this.getActivity(), merge);
			task.setNotify(this);
			LoginResult lResult = Utilities.getLoginDetails(getActivity());
			User user = lResult.getUser();
			
			KVEntry<String, String> android = new KVEntry<String, String>(Utilities.CLIENT , "1");
			KVEntry<String, String> what	 = new KVEntry<String, String>(Utilities.WHAT , "transaction");
			KVEntry<String, String> user_id	 = new KVEntry<String, String>("user_id" , user.getServer_u_id()+"");
			task.execute(android, what , user_id);
		}else{
			fire_update();
		}


		super.onActivityCreated(savedInstanceState);
	}
	
	/**
	 * add title to the merged adapters
	 * 
	 * @param title
	 * @return
	 */
	private View addTitleView(String title){
		TextView textView = new TextView(getActivity());
		
		textView.setText(title);
		textView.setBackgroundResource(R.drawable.gradient_bg_hover);
		textView.setGravity(Gravity.CENTER);
		textView.setHeight(50);
		
		
		return textView;
	}

	@Override
	public void fire_update() {
		// TODO Auto-generated method stub
		ShareHelper sHelper = new ShareHelper(getActivity());
		for(Share share : sHelper.getAll()){
			sAdapter.add(share);
		}
		
		WithdrawalHelper wHelper = new WithdrawalHelper(getActivity());
		for(Withdrawal withdraw : wHelper.getAll()){
			wAdapter.add(withdraw);
		}
		
		progress.setVisibility(View.INVISIBLE);
		
	}
	
}
