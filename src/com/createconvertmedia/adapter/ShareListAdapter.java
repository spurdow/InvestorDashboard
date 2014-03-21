package com.createconvertmedia.adapter;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.createconvertmedia.dbentity.DatabaseHandler;
import com.createconvertmedia.dbentity.ShareHelper;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.iface.IAdapterActions;
import com.createconvertmedia.iface.IGeneric;
import com.createconvertmedia.investordashboard.R;

public class ShareListAdapter extends AbstractListAdapter<Share> implements IAdapterActions<Share> , IGeneric<Share>{
	
	private LayoutInflater inflater;

	public ShareListAdapter(Context context, List<Share> lists) {
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
			child = inflater.inflate(R.layout.share_history_row, null);
			holder.sh_amount = (TextView) child.findViewById(R.id.sh_amount);
			holder.sh_share_value = (TextView) child.findViewById(R.id.sh_share_value);
			holder.sh_total_share_purchased = (TextView) child.findViewById(R.id.sh_total_share_purchased);
			holder.sh_date = (TextView) child.findViewById(R.id.sh_date);
			child.setTag(holder);
		}else{
			holder = (ViewHolder) child.getTag();
		}
		
		holder.sh_amount.setText(getObject(position).getServer_amount_invested()+"");
		holder.sh_share_value.setText(getObject(position).getServer_share_value()+"");
		holder.sh_total_share_purchased.setText(getObject(position).getServer_total_share_purchased()+"");
		holder.sh_date.setText(getObject(position).getServer_share_added_date());
		return child;
	}
	
	private class ViewHolder {
		TextView sh_amount;
		TextView sh_share_value;
		TextView sh_total_share_purchased;
		TextView sh_date;
	}

	@Override
	public void add(Share e) {
		// TODO Auto-generated method stub
		getList().add(e);
		notifyDataSetChanged();
	}

	@Override
	public void delete(int index , long id ) {
		// TODO Auto-generated method stub
		getList().remove(index);
		notifyDataSetChanged();
	}

	@Override
	public void update(int pos, Share object) {
		// TODO Auto-generated method stub

		Toast.makeText(getContext(), "Not yet implemented!", Toast.LENGTH_LONG).show();
	}

	@Override
	public List<Share> getAll() {
		// TODO Auto-generated method stub
		return getList();
	}
}
