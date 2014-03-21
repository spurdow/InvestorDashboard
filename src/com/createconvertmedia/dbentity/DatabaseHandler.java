package com.createconvertmedia.dbentity;

import com.createconvertmedia.entity.Share;
import com.createconvertmedia.entity.Withdrawal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

	public final static String DB_NAME = "investor.db";
	
	public final static int VERSION = 1;
	
	private static DatabaseHandler handler;
	
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
		/**
		 * Share class database key 
		 * handles its creation of table and indexing 
		 * of column server_id
		 */
		Share.DatabaseKey shareKey = new Share.DatabaseKey();
		arg0.execSQL(shareKey.CREATE_TABLE);
		arg0.execSQL(shareKey.INDEX);
		
		/**
		 * Withdraw class database key 
		 * handles its creation of table and indexing 
		 * of column server_id
		 */
		Withdrawal.DatabaseKey withKey = new Withdrawal.DatabaseKey();
		arg0.execSQL(withKey.CREATE_TABLE);
		arg0.execSQL(withKey.INDEX);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Share.DatabaseKey shareKey = new Share.DatabaseKey();
		arg0.execSQL(shareKey.DROP_TABLE);
		
		onCreate(arg0);
	}

}
