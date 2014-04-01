package com.createconvertmedia.dbentity;

import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.entity.Project;
import com.createconvertmedia.entity.Share;
import com.createconvertmedia.entity.Withdrawal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper{

	public final static String DB_NAME = "investor.db";
	
	public final static int VERSION = 1;

	private static final String TAG = DatabaseHandler.class.getSimpleName();
	
	private static DatabaseHandler handler;
	
	/**
	 * Share class database key 
	 * handles its creation of table and indexing 
	 * of column server_id
	 */
	private final Share.DatabaseKey shareKey = new Share.DatabaseKey();
	
	/**
	 * Withdraw class database key 
	 * handles its creation of table and indexing 
	 * of column server_id
	 */
	private final Withdrawal.DatabaseKey withKey = new Withdrawal.DatabaseKey();
	
	/**
	 * Pdf_download class database key
	 * handles its creation of table and indexing
	 * of column server_id
	 */
	private final Pdf_download.DatabaseKey downloadKey = new Pdf_download.DatabaseKey();

	/**
	 * Project class database key
	 * handles its creation of table and indexing
	 * of column server_id
	 */
	private final Project.DatabaseKey projectKey = new Project.DatabaseKey();

	/**
	 * 
	 * @param context
	 */
	private DatabaseHandler(Context context) {
		super(context, DB_NAME , null, VERSION);
		// TODO Auto-generated constructor stub
	}
	/**
	 * singleton design pattern for DatabaseHandler
	 * @param context
	 * @return
	 */
	public static DatabaseHandler getInstance(Context context){
		if(handler == null || null == handler){
			handler = new DatabaseHandler(context);
		}
		return handler;
	}
	
	

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

		arg0.execSQL(shareKey.CREATE_TABLE);
		arg0.execSQL(shareKey.INDEX);
		

		arg0.execSQL(withKey.CREATE_TABLE);
		arg0.execSQL(withKey.INDEX);
		

		arg0.execSQL(downloadKey.CREATE_TABLE);
		arg0.execSQL(downloadKey.INDEX);
				
		
		arg0.execSQL(projectKey.CREATE_TABLE);
		arg0.execSQL(projectKey.COL_NAME_INDEX);
		arg0.execSQL(projectKey.COL_YEAR_INDEX);
		arg0.execSQL(projectKey.COL_QUARTER_INDEX);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL(shareKey.DROP_TABLE);
		arg0.execSQL(withKey.DROP_TABLE);
		arg0.execSQL(downloadKey.DROP_TABLE);
		arg0.execSQL(projectKey.DROP_TABLE);
				
		onCreate(arg0);
	}

}
