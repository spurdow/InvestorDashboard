package com.createconvertmedia.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.iface.IAdapterActions;
import com.createconvertmedia.investordashboard.R;

@SuppressLint("NewApi")
public class DownloadListAdapter extends AbstractListAdapter<Pdf_download> implements IAdapterActions<Pdf_download> {
	
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
		final String url =  Utilities.HOST +"/images/uploads/pdf_downloads/"+getObject(position).getServer_pdf_file_name();
		final String description = "Downloading " + getObject(position).getServer_pdf_file_name() ;
		final String title = getObject(position).getServer_pdf_title();
		final String nameFile = getObject(position).getServer_pdf_file_name();
		holder.pd_image.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
				//Set the url in uri to be parse
				Uri uri = Uri.parse( url );
				//instantiate request using the uri
				DownloadManager.Request request = new DownloadManager.Request(uri);
				//set request description to be seen in notification
				request.setDescription(description);
				//set request title to be seen also in notification
				request.setTitle(title);
				//check whether we can use allowScanning and notificationVisibility
				//by checking build version
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
					request.allowScanningByMediaScanner();
					request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				}
				//set the destination directory 
				request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameFile);
				downloadManager.enqueue(request);
			}
			
		});
		//final String url = Utilities.HOST +"/images/uploads/pdf_downloads/"+getObject(position).getServer_pdf_file_name();
		//download(url , holder.pd_image);
		
		
		return child;
	}
	
	private class ViewHolder {
		TextView pd_title;
		TextView pd_created;
		ImageButton pd_image;
	}

	@Override
	public void add(Pdf_download e) {
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
	public void update(int pos, Pdf_download object) {
		// TODO Auto-generated method stub
		Toast.makeText(getContext(), "Not Yet Supported!", Toast.LENGTH_LONG).show();
	}

	@Override
	public List<Pdf_download> getAll() {
		// TODO Auto-generated method stub
		return getList();
	}




}
