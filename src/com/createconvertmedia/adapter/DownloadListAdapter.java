package com.createconvertmedia.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.investordashboard.R;

public class DownloadListAdapter extends AbstractListAdapter<Pdf_download> {
	
	private LayoutInflater inflater;

	public DownloadListAdapter(Context context, List<Pdf_download> lists) {
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
			child = inflater.inflate(R.layout.pdf_download_row, null);
			holder.pd_title = (TextView) child.findViewById(R.id.pd_title);
			holder.pd_created = (TextView) child.findViewById(R.id.pd_created);
			holder.pd_image = (ImageButton) child.findViewById(R.id.pd_image);
			child.setTag(holder);
		}else{
			holder = (ViewHolder) child.getTag();
		}
		holder.pd_created.setText(getObject(position).getServer_created());
		holder.pd_title.setText(getObject(position).getServer_pdf_title());
		
		//final String url = Utilities.HOST +"/images/uploads/pdf_downloads/"+getObject(position).getServer_pdf_file_name();
		//download(url , holder.pd_image);
		
		
		return child;
	}
	
	private class ViewHolder {
		TextView pd_title;
		TextView pd_created;
		ImageButton pd_image;
	}


}
