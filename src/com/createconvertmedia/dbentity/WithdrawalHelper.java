package com.createconvertmedia.dbentity;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.createconvertmedia.entity.Withdrawal;
import com.createconvertmedia.iface.IHelperActions;

public class WithdrawalHelper implements IHelperActions<Withdrawal>{

	private static final String TAG = Withdrawal.class.getSimpleName();
	private Context mContext;
	private final Withdrawal.DatabaseKey keys = new Withdrawal.DatabaseKey();
	
	public WithdrawalHelper(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public long add(Withdrawal object) {
		// TODO Auto-generated method stub
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(keys.SERVER_ID, object.getServer_id());
		values.put(keys.SERVER_ACCOUNT_TYPE	, object.getServer_account_type());
		values.put(keys.SERVER_AMOUNT, object.getServer_amount());
		values.put(keys.SERVER_COMMENT, object.getServer_comment());
		values.put(keys.SERVER_CREATED, object.getServer_created());
		values.put(keys.SERVER_MODIFIED, object.getServer_modified());
		values.put(keys.SERVER_REPLY_DATE, object.getServer_reply_date());
		values.put(keys.SERVER_REQUESTED_DATE, object.getServer_requested_date());
		values.put(keys.SERVER_STATUS, object.getServer_status());
		values.put(keys.SERVER_WITHDRAWAL_STATUS, object.getServer_withdrawal_status());
		try{
			return db.insertOrThrow(keys.TABLE, null, values);
		}catch(Exception e){
			Log.w(TAG,"Cannot Insert error =  " +  e.getMessage());
		}
		return -1;
	}

	@Override
	public int update(long id, Withdrawal object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		
		return db.delete(keys.TABLE	, "id = ?", new String[]{String.valueOf(id)});
		
	}
	
	@Override
	public List<Withdrawal> getAll(){
		List<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID, null);
		if(c.moveToFirst()){
			do{
				Withdrawal withdrawal = new Withdrawal();
				withdrawal.setId(c.getLong(c.getColumnIndex(keys.ID)));
				withdrawal.setServer_account_type(c.getString(c.getColumnIndex(keys.SERVER_ACCOUNT_TYPE)));
				withdrawal.setServer_amount(c.getDouble(c.getColumnIndex(keys.SERVER_AMOUNT)));
				withdrawal.setServer_comment(c.getString(c.getColumnIndex(keys.SERVER_COMMENT)));
				withdrawal.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				withdrawal.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				withdrawal.setServer_reply_date(c.getString(c.getColumnIndex(keys.SERVER_REPLY_DATE)));
				withdrawal.setServer_requested_date(c.getString(c.getColumnIndex(keys.SERVER_REQUESTED_DATE)));
				withdrawal.setServer_status(c.getInt(c.getColumnIndex(keys.SERVER_STATUS)));
				withdrawal.setServer_withdrawal_status(c.getString(c.getColumnIndex(keys.SERVER_WITHDRAWAL_STATUS)));
				withdrawals.add(withdrawal);
			}while(c.moveToNext());
		}
		
		return withdrawals;
	}

	@Override
	public List<Withdrawal> getAllByLimit(int offset, int limit) {
		// TODO Auto-generated method stub
		if(offset < 0 || limit < 0){
			return getAll();
		}
		
		List<Withdrawal> withdrawals = new ArrayList<Withdrawal>();
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY ID LIMIT ?,?", new String[]{offset+"",limit+""});
		if(c.moveToFirst()){
			do{
				Withdrawal withdrawal = new Withdrawal();
				withdrawal.setId(c.getLong(c.getColumnIndex(keys.ID)));
				withdrawal.setServer_account_type(c.getString(c.getColumnIndex(keys.SERVER_ACCOUNT_TYPE)));
				withdrawal.setServer_amount(c.getDouble(c.getColumnIndex(keys.SERVER_AMOUNT)));
				withdrawal.setServer_comment(c.getString(c.getColumnIndex(keys.SERVER_COMMENT)));
				withdrawal.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				withdrawal.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				withdrawal.setServer_reply_date(c.getString(c.getColumnIndex(keys.SERVER_REPLY_DATE)));
				withdrawal.setServer_requested_date(c.getString(c.getColumnIndex(keys.SERVER_REQUESTED_DATE)));
				withdrawal.setServer_status(c.getInt(c.getColumnIndex(keys.SERVER_STATUS)));
				withdrawal.setServer_withdrawal_status(c.getString(c.getColumnIndex(keys.SERVER_WITHDRAWAL_STATUS)));
				withdrawals.add(withdrawal);
			}while(c.moveToNext());
		}
		
		return withdrawals;
	}


}
