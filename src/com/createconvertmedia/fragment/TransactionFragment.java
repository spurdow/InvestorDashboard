package com.createconvertmedia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.commonsware.cwac.merge.MergeAdapter;
import com.createconvertmedia.adapter.ShareListAdapter;
import com.createconvertmedia.adapter.WithdrawListAdapter;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.entity.Withdrawal;
import com.createconvertmedia.investordashboard.R;


public class TransactionFragment extends SherlockListFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.content_layout, container , false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		MergeAdapter merge = new MergeAdapter();
		

		List<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
		withdrawals.add(new Withdrawal(1,1,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		withdrawals.add(new Withdrawal(2,2,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		withdrawals.add(new Withdrawal(3,3,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		withdrawals.add(new Withdrawal(4,4,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		withdrawals.add(new Withdrawal(5,5,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		withdrawals.add(new Withdrawal(6,6,22,"type" , 10.00 , "date" , "status" , "comment" , "reply date" , "created" , "modified" , 1));
		WithdrawListAdapter wAdapter =  new WithdrawListAdapter(this.getActivity().getApplicationContext() , withdrawals);
		
		List<Share> shares = new ArrayList<Share>();
		shares.add(new Share(1,1,22,10000,0.25,1000,"date","created","modified" ,1));
		shares.add(new Share(2,2,22,10000,0.25,1000,"date","created","modified" ,1));
		shares.add(new Share(3,3,22,10000,0.25,1000,"date","created","modified" ,1));
		shares.add(new Share(4,4,22,10000,0.25,1000,"date","created","modified" ,1));
		shares.add(new Share(5,5,22,10000,0.25,1000,"date","created","modified" ,1));
		ShareListAdapter sAdapter = new ShareListAdapter(this.getActivity().getApplicationContext() ,shares);
		
		merge.addView(addTitleView("Transaction History"));
		merge.addAdapter(sAdapter);
		merge.addView(addTitleView("Withdrawal History"));
		merge.addAdapter(wAdapter);
		
		setListAdapter(merge);
		
		super.onActivityCreated(savedInstanceState);
	}
	
	
	private View addTitleView(String title){
		TextView textView = new TextView(getActivity());
		
		textView.setText(title);
		textView.setBackgroundResource(R.drawable.gradient_bg_hover);
		textView.setGravity(Gravity.CENTER);
		textView.setHeight(50);
		
		return textView;
	}
	
}
