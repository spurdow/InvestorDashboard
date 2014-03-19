package com.createconvertmedia.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.createconvertmedia.entity.Menu;
import com.createconvertmedia.investordashboard.R;
import com.readystatesoftware.viewbadger.BadgeView;

public class MenuListAdapter extends AbstractListAdapter<Menu>{

	private LayoutInflater inflater;
	
	public MenuListAdapter(Context context, List<Menu> lists) {
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
		ViewHolder vHolder = null;
		if(child == null){
			vHolder = new ViewHolder();
			child = inflater.inflate(R.layout.menu_list_row, null);
			vHolder.menu = (TextView) child.findViewById(R.id.txt_menu_name);
			vHolder.notify = new BadgeView(getContext(), child.findViewById(R.id.txt_menu_notif));
			child.setTag(vHolder);
		}else{
			vHolder = (ViewHolder) child.getTag();
		}
		
		vHolder.menu.setText(getObject(position).getName());
		int count = getObject(position).getNotif_no();
		if(count > 0 ){
			vHolder.notify.setText(String.valueOf(count));
			vHolder.notify.setBadgePosition(BadgeView.POSITION_CENTER);
			vHolder.notify.show();
		}
		
		
		return child;
	}
	
	private class ViewHolder{
		TextView menu;
		BadgeView notify;
	}

}
