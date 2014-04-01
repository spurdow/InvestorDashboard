package com.createconvertmedia.dbentity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.createconvertmedia.adapter.ProjectAdapter.Type;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.iface.IHelperActions;

public class ProjectHelper implements IHelperActions<Project>{
	
	private static final String TAG = ProjectHelper.class.getSimpleName();
	private Context mContext;
	private final Project.DatabaseKey keys = new Project.DatabaseKey();

	private Type type;
	
	public ProjectHelper(Context context){
		this(context, null);
	}
	
	public ProjectHelper(Context mContext , Type type) {
		super();
		this.mContext = mContext;
		this.type = type;
	}

	@Override
	public long add(Project object) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(keys.SERVER_NAME, object.getServer_name());
		values.put(keys.SERVER_YEAR, object.getServer_year());
		values.put(keys.SERVER_Q_QUARTER, object.getServer_q_quarter());
		values.put(keys.SERVER_Q_AGGREGATED, object.getServer_q_aggregated());
		values.put(keys.SERVER_Q_CADNETEARNING, object.getServer_q_cadnetearning());
		values.put(keys.SERVER_Q_COMPOUND, object.getServer_q_compound());
		values.put(keys.SERVER_Q_DIVIDEND, object.getServer_q_dividend());
		values.put(keys.SERVER_Q_DIVIDENDPERSHARE, object.getServer_q_dividendpershare());
		values.put(keys.SERVER_Q_COMPOUNDPERSHARE, object.getServer_q_compoundpershare());
		values.put(keys.SERVER_Q_DIVIDENDSHARE, object.getServer_q_dividendshare());
		values.put(keys.SERVER_Q_COMPOUNDSHARE, object.getServer_q_compoundshare());
		values.put(keys.SERVER_Q_NETEARNING, object.getServer_q_netearning());
		values.put(keys.SERVER_Q_OPERATIONAL, object.getServer_q_operational());
		values.put(keys.SERVER_Q_TOTALSHARE, object.getServer_q_totalshare());
		values.put(keys.SERVER_STATUS, object.getServer_status());
		
		try{
			return db.insertOrThrow(keys.TABLE, null, values);
		}catch(Exception ex){
			Log.w(TAG, "Cannot Insert error =  " + ex.getMessage());
		}
		
		return -1;
	}

	@Override
	public int update(long id, Project object) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(keys.SERVER_NAME, object.getServer_name());
		values.put(keys.SERVER_YEAR, object.getServer_year());
		values.put(keys.SERVER_Q_QUARTER, object.getServer_q_quarter());
		values.put(keys.SERVER_Q_AGGREGATED, object.getServer_q_aggregated());
		values.put(keys.SERVER_Q_CADNETEARNING, object.getServer_q_cadnetearning());
		values.put(keys.SERVER_Q_COMPOUND, object.getServer_q_compound());
		values.put(keys.SERVER_Q_DIVIDEND, object.getServer_q_dividend());
		values.put(keys.SERVER_Q_DIVIDENDPERSHARE, object.getServer_q_dividendpershare());
		values.put(keys.SERVER_Q_COMPOUNDPERSHARE, object.getServer_q_compoundpershare());
		values.put(keys.SERVER_Q_DIVIDENDSHARE, object.getServer_q_dividendshare());
		values.put(keys.SERVER_Q_COMPOUNDSHARE, object.getServer_q_compoundshare());
		values.put(keys.SERVER_Q_NETEARNING, object.getServer_q_netearning());
		values.put(keys.SERVER_Q_OPERATIONAL, object.getServer_q_operational());
		values.put(keys.SERVER_Q_TOTALSHARE, object.getServer_q_totalshare());
		values.put(keys.SERVER_STATUS, object.getServer_status());
		
		int result = db.update(keys.TABLE, values, keys.SERVER_NAME  + " = ? AND " + keys.SERVER_YEAR + " = ? AND " + keys.SERVER_Q_QUARTER + " = ? ", new String[]{object.getServer_name(),object.getServer_year(),object.getServer_q_quarter()+""});
		
		return result;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		
		return  db.delete(keys.TABLE	, "id = ?", new String[]{String.valueOf(id)});
	}

	
	public Project getSpecificProject(Project referenceProject){

		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		final String query = "SELECT * FROM " + keys.TABLE + " WHERE " + keys.SERVER_NAME + " = ? " + " AND " + keys.SERVER_YEAR + " = ? AND " + keys.SERVER_Q_QUARTER + " = ?";
		
		Cursor c = db.rawQuery(query, new String[]{referenceProject.getServer_name() , referenceProject.getServer_year() , referenceProject.getServer_q_quarter()+""});
		if(c.getCount() > 0){
			c.moveToFirst();
			referenceProject.setId(c.getLong(c.getColumnIndex(keys.ID)));
			return referenceProject;
		}
		
		return null;
	}
	
	public List<Project> getAllByName(String name) {
		// TODO Auto-generated method stub
		List<Project> quarters = new ArrayList<Project>();
		
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		
		String query = "SELECT * FROM " + keys.TABLE  ;
		if(type == Type.Projected_Earnings){
			query+= " WHERE " + keys.SERVER_NAME + " = " + name + " AND " + keys.SERVER_YEAR + " = " + year ;
		}else if(type == Type.Project_Earnings){
			query+= " WHERE " + keys.SERVER_NAME + " != " + name + " AND " + keys.SERVER_YEAR + " = " + year;
		}else
			query+= " WHERE " + keys.SERVER_NAME + " = '" + name + "' AND " + keys.SERVER_YEAR + " = " + year;
		Cursor c = db.rawQuery(query, null);
		
		if(c.moveToFirst()){
			do{
				Project q = new Project();
				q.setId(c.getLong(c.getColumnIndex(keys.ID)));
				q.setServer_year(c.getString(c.getColumnIndex(keys.SERVER_YEAR)));
				q.setServer_name(c.getString(c.getColumnIndex(keys.SERVER_NAME)));
				q.setServer_q_aggregated(c.getDouble(c.getColumnIndex(keys.SERVER_Q_AGGREGATED)));
				q.setServer_q_cadnetearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_CADNETEARNING)));
				q.setServer_q_compound(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUND)));
				q.setServer_q_compoundpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDPERSHARE)));
				q.setServer_q_compoundshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDSHARE)));
				q.setServer_q_dividend(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDEND)));
				q.setServer_q_dividendpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDPERSHARE)));
				q.setServer_q_dividendshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDSHARE)));
				q.setServer_q_netearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_NETEARNING)));
				q.setServer_q_operational(c.getDouble(c.getColumnIndex(keys.SERVER_Q_OPERATIONAL)));
				q.setServer_q_quarter(c.getInt(c.getColumnIndex(keys.SERVER_Q_QUARTER)));
				q.setServer_q_totalshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_TOTALSHARE)));
				quarters.add(q);
				
			}while(c.moveToNext());
		}
		
		return quarters;
	}
	
	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		List<Project> quarters = new ArrayList<Project>();
		
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		
		String query = "SELECT * FROM " + keys.TABLE  ;
		if(type == Type.Projected_Earnings){
			query+= " WHERE " + keys.SERVER_NAME + " = MVP AND " + keys.SERVER_YEAR + " = " + year ;
		}else if(type == Type.Project_Earnings){
			query+= " WHERE " + keys.SERVER_NAME + " != MVP AND " + keys.SERVER_YEAR + " = " + year;
		}else
			query+= " WHERE " + keys.SERVER_YEAR + " = " + year;
		Cursor c = db.rawQuery(query, null);
		
		if(c.moveToFirst()){
			do{
				Project q = new Project();
				q.setId(c.getLong(c.getColumnIndex(keys.ID)));
				q.setServer_year(c.getString(c.getColumnIndex(keys.SERVER_YEAR)));
				q.setServer_name(c.getString(c.getColumnIndex(keys.SERVER_NAME)));
				q.setServer_q_aggregated(c.getDouble(c.getColumnIndex(keys.SERVER_Q_AGGREGATED)));
				q.setServer_q_cadnetearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_CADNETEARNING)));
				q.setServer_q_compound(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUND)));
				q.setServer_q_compoundpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDPERSHARE)));
				q.setServer_q_compoundshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDSHARE)));
				q.setServer_q_dividend(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDEND)));
				q.setServer_q_dividendpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDPERSHARE)));
				q.setServer_q_dividendshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDSHARE)));
				q.setServer_q_netearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_NETEARNING)));
				q.setServer_q_operational(c.getDouble(c.getColumnIndex(keys.SERVER_Q_OPERATIONAL)));
				q.setServer_q_quarter(c.getInt(c.getColumnIndex(keys.SERVER_Q_QUARTER)));
				q.setServer_q_totalshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_TOTALSHARE)));
				quarters.add(q);
				
			}while(c.moveToNext());
		}
		
		return quarters;
	}

	@Override
	public List<Project> getAllByLimit(int offset, int limit) {
		// TODO Auto-generated method stub
		if(offset < 0 && limit < 0){
			return getAll();
		}
		
		List<Project> quarters = new ArrayList<Project>();
		
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID + " LIMIT ?,?", new String[]{offset+"",limit+""});
		
		if(c.moveToFirst()){
			do{
				Project q = new Project();
				q.setId(c.getLong(c.getColumnIndex(keys.ID)));
				q.setServer_year(c.getString(c.getColumnIndex(keys.SERVER_YEAR)));
				q.setServer_name(c.getString(c.getColumnIndex(keys.SERVER_NAME)));
				q.setServer_q_aggregated(c.getDouble(c.getColumnIndex(keys.SERVER_Q_AGGREGATED)));
				q.setServer_q_cadnetearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_CADNETEARNING)));
				q.setServer_q_compound(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUND)));
				q.setServer_q_compoundpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDPERSHARE)));
				q.setServer_q_compoundshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_COMPOUNDSHARE)));
				q.setServer_q_dividend(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDEND)));
				q.setServer_q_dividendpershare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDPERSHARE)));
				q.setServer_q_dividendshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_DIVIDENDSHARE)));
				q.setServer_q_netearning(c.getDouble(c.getColumnIndex(keys.SERVER_Q_NETEARNING)));
				q.setServer_q_operational(c.getDouble(c.getColumnIndex(keys.SERVER_Q_OPERATIONAL)));
				q.setServer_q_quarter(c.getInt(c.getColumnIndex(keys.SERVER_Q_QUARTER)));
				q.setServer_q_totalshare(c.getDouble(c.getColumnIndex(keys.SERVER_Q_TOTALSHARE)));
				quarters.add(q);
				
			}while(c.moveToNext());
		}
		
		return quarters;
	}

}
