package com.createconvertmedia.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockListFragment;
import com.createconvertmedia.adapter.ProjectAdapter;
import com.createconvertmedia.adapter.ProjectAdapter.Type;
import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.commons.Utilities.LaunchKey;
import com.createconvertmedia.dbentity.ProjectHelper;
import com.createconvertmedia.entity.LoginResult;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.entity.User;
import com.createconvertmedia.entry.KVEntry;
import com.createconvertmedia.iface.INotifyUpdate;
import com.createconvertmedia.investordashboard.R;
import com.createconvertmedia.tasks.ProjectRequestTask;
import com.google.gson.Gson;

public class ProjectFragment extends SherlockListFragment {

	private static final String TAG = ProjectFragment.class.getSimpleName();
	private ProjectAdapter adapter;
	private ProgressBar pb;
	private Type type;
	private int pos;
	private String title;
	
	public static ProjectFragment newInstance(int position , String name ){
		ProjectFragment f = new ProjectFragment();
		
        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("pos", position);
        args.putString("name", name);
        f.setArguments(args);
        

		return f;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		pos = getArguments() != null ? getArguments().getInt("pos") : 0;
		title = getArguments() != null ? getArguments().getString("name") : "";

		View v = inflater.inflate(R.layout.content_layout, container , false);
		pb = (ProgressBar) v.findViewById(R.id.content_progressbar);
		pb.setVisibility(View.VISIBLE);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<Project>();
		
		final ProjectHelper helper = new ProjectHelper(getActivity());
		
		for(Project p : helper.getAllByName(title)){
			Log.w(TAG, p.getServer_q_quarter() + "");
			projects.add(p);
		}

		type = (title.equals("MVP"))?Type.Projected_Earnings:Type.Project_Earnings;
		
		adapter = new ProjectAdapter(getActivity(), projects ,type);
		
		setListAdapter(adapter);
		
		super.onActivityCreated(savedInstanceState);
	}



	public String getTitle() {
		return " --- " + title + " --- ";
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
