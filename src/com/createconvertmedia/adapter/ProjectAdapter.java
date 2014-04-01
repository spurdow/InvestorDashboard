package com.createconvertmedia.adapter;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.entity.User;
import com.createconvertmedia.iface.IAdapterActions;
import com.createconvertmedia.investordashboard.R;

public class ProjectAdapter extends AbstractListAdapter<Project> implements IAdapterActions<Project>{

	private static final String TAG = ProjectAdapter.class.getSimpleName();
	private LayoutInflater inflater;
	private Type type;
	private User user;
	
	private final DecimalFormat dollar_format = new DecimalFormat("$###,###,###,###,###.##");
	private final DecimalFormat euro_format = new DecimalFormat("€###,###,###,###,###.##");
	private final DecimalFormat share_format = new DecimalFormat("$###,###,###.#####");
	
	public enum Type{
		Projected_Earnings,
		Project_Earnings
	}
	
	public ProjectAdapter(Context context, List<Project> lists , Type type) {
		super(context, lists);
		// TODO Auto-generated constructor stub
		inflater = LayoutInflater.from(context);
		this.type = type;
		user = Utilities.getLoginDetails(getContext()).getUser();
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Project e) {
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
	public void update(int pos, Project object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return getList();
	}

	@Override
	public View getOverridedView(int position, View child, ViewGroup root) {
		// TODO Auto-generated method stub
		final int quarter = getObject(position).getServer_q_quarter();
		
		if(type == Type.Projected_Earnings){
			ProjectedEarningsHolder holder = null;
			if(child == null){
				holder = new ProjectedEarningsHolder();
				child = inflater.inflate(R.layout.projected_earnings_row, null);
				holder.txt_quarter = (TextView) child.findViewById(R.id.txt_quarter);
				holder.txt_quarter_date = (TextView) child.findViewById(R.id.txt_quarter_date);
				holder.txt_whos_earnings = (TextView) child.findViewById(R.id.txt_whos_earnings);
				holder.txt_quarterly_dividend = (TextView) child.findViewById(R.id.txt_quarterly_dividend);
				holder.txt_d_per_share_value = (TextView) child.findViewById(R.id.txt_d_per_share_value);
				holder.txt_d_amount_earned = (TextView) child.findViewById(R.id.txt_d_amount_earned);
				holder.txt_whos_compounding_share_earnings = (TextView) child.findViewById(R.id.txt_whos_compounding_share_earnings);
				holder.txt_compounding_share_value = (TextView) child.findViewById(R.id.txt_compounding_share_value);
				holder.txt_c_per_share_value = (TextView) child.findViewById(R.id.txt_c_per_share_value);
				holder.txt_c_amount_earned = (TextView) child.findViewById(R.id.txt_c_amount_earned);
				holder.txt_operational_expenses = (TextView) child.findViewById(R.id.txt_operational_expenses);
				holder.txt_net_earnings = (TextView) child.findViewById(R.id.txt_net_earnings);
				holder.txt_cad_net_earnings = (TextView) child.findViewById(R.id.txt_cad_net_earnings);
				holder.aggregated_investor_share = (TextView) child.findViewById(R.id.txt_aggregated_investor_share);
				holder.txt_allocated_to_charity = (TextView) child.findViewById(R.id.txt_allocated_to_charity);
				child.setTag(holder);
			}else{
				holder = (ProjectedEarningsHolder) child.getTag();
			}
			
			


			holder.txt_quarter.setText("Quarter " + quarter);
			holder.txt_quarter_date.setText(getQuarterDates(quarter));
			holder.txt_whos_earnings.setText(user.getServer_u_name());
			holder.txt_quarterly_dividend.setText(dollar_format.format(getObject(position).getServer_q_dividend()));
			holder.txt_d_per_share_value.setText(share_format.format(getObject(position).getServer_q_dividendpershare()));
			holder.txt_d_amount_earned.setText(dollar_format.format(getObject(position).getServer_q_dividendshare()));
			holder.txt_whos_compounding_share_earnings.setText(user.getServer_u_name()+"");
			holder.txt_compounding_share_value.setText(dollar_format.format(getObject(position).getServer_q_compound()));
			holder.txt_c_per_share_value.setText(share_format.format(getObject(position).getServer_q_compoundpershare()));
			holder.txt_c_amount_earned.setText(dollar_format.format(getObject(position).getServer_q_compoundshare()));
			holder.txt_operational_expenses.setText(euro_format.format(getObject(position).getServer_q_operational()));
			holder.txt_net_earnings.setText(euro_format.format(getObject(position).getServer_q_netearning()));
			holder.txt_cad_net_earnings.setText(dollar_format.format(getObject(position).getServer_q_cadnetearning()));
			holder.aggregated_investor_share.setText(dollar_format.format(getObject(position).getServer_q_aggregated()));
			holder.txt_allocated_to_charity.setText(dollar_format.format(getObject(position).getServer_q_cadnetearning()));
		}else if(type == Type.Project_Earnings){
			ProjectEarningsHolder holder = null;
			if(child == null){
				holder = new ProjectEarningsHolder();
				child = inflater.inflate(R.layout.project_earnings_row, null);
				holder.pe_quarter = (TextView) child.findViewById(R.id.pe_quarter);
				holder.pe_quarter_date = (TextView) child.findViewById(R.id.pe_quarter_date);
				holder.pe_operational_expenses = (TextView) child.findViewById(R.id.pe_operational_expenses);
				holder.pe_cad_net_earnings = (TextView) child.findViewById(R.id.pe_cad_net_earnings);
				holder.pe_aggregated_investor_share = (TextView) child.findViewById(R.id.pe_aggregated_investor_share);
				holder.pe_allocated_to_charity = (TextView) child.findViewById(R.id.pe_allocated_to_charity);
				holder.pe_whos_earnings = (TextView) child.findViewById(R.id.pe_whos_earnings);
				holder.pe_quarterly_dividend = (TextView) child.findViewById(R.id.pe_quarterly_dividend);
				holder.pe_d_per_share_value = (TextView) child.findViewById(R.id.pe_d_per_share_value);
				holder.pe_d_amount_earned = (TextView) child.findViewById(R.id.pe_d_amount_earned);
				holder.pe_whos_compounding_share_earnings = (TextView) child.findViewById(R.id.pe_whos_compounding_share_earnings);
				holder.pe_compounding_share_value = (TextView) child.findViewById(R.id.pe_compounding_share_value);
				holder.pe_c_per_share_value =(TextView) child.findViewById(R.id.pe_c_per_share_value);
				holder.pe_c_amount_earned = (TextView) child.findViewById(R.id.pe_c_amount_earned);
				holder.pe_total_amt_earned = (TextView) child.findViewById(R.id.pe_total_amt_earned);
				child.setTag(holder);
			}else{
				holder = (ProjectEarningsHolder) child.getTag();
			}
			double cadnetearnings = getObject(position).getServer_q_cadnetearning();
			double div_amt_earned = getObject(position).getServer_q_dividendshare();
			double com_amt_earned = getObject(position).getServer_q_compoundshare();
			holder.pe_quarter.setText("Quarter " + quarter);
			holder.pe_quarter_date.setText(getQuarterDates(quarter));
			holder.pe_operational_expenses.setText(dollar_format.format(getObject(position).getServer_q_operational()));
			holder.pe_cad_net_earnings.setText(dollar_format.format(getObject(position).getServer_q_cadnetearning()));
			holder.pe_aggregated_investor_share.setText(dollar_format.format(getObject(position).getServer_q_aggregated()));
			holder.pe_allocated_to_charity.setText(dollar_format.format(cadnetearnings/10)); 
			holder.pe_whos_earnings.setText(user.getServer_u_name());
			holder.pe_quarterly_dividend.setText(dollar_format.format(getObject(position).getServer_q_dividend()));
			holder.pe_d_per_share_value.setText(share_format.format(getObject(position).getServer_q_dividendpershare()));
			holder.pe_d_amount_earned.setText(dollar_format.format(div_amt_earned));
			holder.pe_whos_compounding_share_earnings.setText(user.getServer_u_name());
			holder.pe_compounding_share_value.setText(dollar_format.format(getObject(position).getServer_q_compound()));
			holder.pe_c_per_share_value.setText(share_format.format(getObject(position).getServer_q_compoundpershare()));
			holder.pe_c_amount_earned.setText(dollar_format.format(com_amt_earned));
			double amt_earned = div_amt_earned + com_amt_earned;
			holder.pe_total_amt_earned.setText(dollar_format.format(amt_earned));
			
			Log.i(TAG , amt_earned + " = amt_earned");
		}
		
		return child;
	}
	
	
	
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	private String getQuarterDates(int quarter){
		final String[] quarter_months = {"Jan 1 - Mar 31" , "Apr 1 - Jun 30" , "Jul 1 - Sep 30" , "Oct 1 - Dec 31"};				
		final String result = quarter_months[quarter - 1];
		return result;
	}


	private class ProjectedEarningsHolder{
		TextView txt_quarter;
		TextView txt_quarter_date;
		
		TextView txt_whos_earnings;
		TextView txt_quarterly_dividend;
		TextView txt_d_per_share_value;
		TextView txt_d_amount_earned;
		
		TextView txt_whos_compounding_share_earnings;
		TextView txt_compounding_share_value;
		TextView txt_c_per_share_value;
		TextView txt_c_amount_earned;
		
		TextView txt_operational_expenses;
		TextView txt_net_earnings;
		TextView txt_cad_net_earnings;
		TextView aggregated_investor_share;
		TextView txt_allocated_to_charity;
	}
	
	private class ProjectEarningsHolder{
		TextView pe_quarter;
		TextView pe_quarter_date;
		
		TextView pe_operational_expenses;
		TextView pe_cad_net_earnings;
		TextView pe_aggregated_investor_share;
		TextView pe_allocated_to_charity;	
		
		TextView pe_whos_earnings;
		TextView pe_quarterly_dividend;
		TextView pe_d_per_share_value;
		TextView pe_d_amount_earned;
		
		TextView pe_whos_compounding_share_earnings;
		TextView pe_compounding_share_value;
		TextView pe_c_per_share_value;
		TextView pe_c_amount_earned;
		TextView pe_total_amt_earned;
		

	}
	

}
