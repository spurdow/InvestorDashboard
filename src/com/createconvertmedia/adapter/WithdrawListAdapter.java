package com.createconvertmedia.adapter;

import java.util.List;

import com.createconvertmedia.entity.Transaction;
import com.createconvertmedia.entity.Withdrawal;
import com.createconvertmedia.iface.IAdapterActions;
import com.createconvertmedia.investordashboard.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

public class WithdrawListAdapter extends AbstractListAdapter<Withdrawal> implements IAdapterActions<Withdrawal>{

	private LayoutInflater inflater;
	
	public WithdrawListAdapter(Context context, List<Withdrawal> lists) {
		super(context, lists);
		// TODO Auto-generated constructor stub
		inflater = LayoutInflater.from(context);
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getOverridedView(int position, View child, ViewGroup root) {
		// TODO Auto-generated method stub
		ViewHolder holder = new ViewHolder();
		if(child == null){
			holder = new ViewHolder();
			child = inflater.inflate(R.layout.withdraw_history_row, null);
			holder.wh_amount = (TextView) child.findViewById(R.id.wh_amount);
			holder.wh_status = (TextView) child.findViewById(R.id.wh_status);
			holder.wh_comment = (TextView) child.findViewById(R.id.wh_comment);
			holder.wh_request_date = (TextView) child.findViewById(R.id.wh_request_date);
			holder.wh_reply_date = (TextView) child.findViewById(R.id.wh_reply_date);
			child.setTag(holder);
		}else{
			holder = (ViewHolder) child.getTag();
		}
		holder.wh_amount.setText(getObject(position).getServer_amount()+"");
		holder.wh_status.setText(getObject(position).getServer_withdrawal_status());
		holder.wh_comment.setText(getObject(position).getServer_comment());
		holder.wh_request_date.setText(getObject(position).getServer_requested_date());
		holder.wh_reply_date.setText(getObject(position).getServer_reply_date());
		
		return child;
	}
	
	private class ViewHolder {
		TextView wh_amount;
		TextView wh_status;
		TextView wh_comment;
		TextView wh_request_date;
		TextView wh_reply_date;
	}

	@Override
	public void add(Withdrawal e) {
		// TODO Auto-generated method stub
		getList().add(e);
		notifyDataSetChanged();
	}

	@Override
	public void delete(int index, long id) {
		// TODO Auto-generated method stub
		getList().remove(index);
		notifyDataSetChanged();
	}

	@Override
	public void update(int pos, Withdrawal object) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), "Not yet implemented", Toast.LENGTH_LONG).show();
	}

	@Override
	public List<Withdrawal> getAll() {
		// TODO Auto-generated method stub
		return getList();
	}

}
