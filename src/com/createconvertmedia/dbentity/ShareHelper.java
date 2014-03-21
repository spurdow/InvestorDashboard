package com.createconvertmedia.dbentity;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.createconvertmedia.entity.Share;
import com.createconvertmedia.iface.IHelperActions;

public class ShareHelper implements IHelperActions<Share>{

	private static final String TAG = ShareHelper.class.getSimpleName();
	private Context mContext;
	private final Share.DatabaseKey keys = new Share.DatabaseKey();
	
	public ShareHelper(Context context){
		this.mContext = context;
	}
	@Override
	public long add(Share e) {
		// TODO Auto-generated method stub
		/**
		 * database handles here
		 */
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(keys.SERVER_ID	, e.getServer_id());
		values.put(keys.SERVER_AMOUNT_INVESTED	, e.getServer_amount_invested());
		values.put(keys.SERVER_CREATED, e.getServer_created());
		values.put(keys.SERVER_MODIFIED, e.getServer_modified());
		values.put(keys.SERVER_SHARE_VALUE	, e.getServer_share_value());
		values.put(keys.SERVER_SHARED_ADDED_DATE, e.getServer_share_added_date());
		values.put(keys.SERVER_STATUS, e.getServer_status());
		values.put(keys.SERVER_TOTAL_SHARE_PURCHASED, e.getServer_status());
		try{
			return db.insertOrThrow(keys.TABLE, null, values);
		}catch(Exception ex){
			Log.w(TAG, "Cannot Insert error =  " + ex.getMessage());
		}
		return -1;
	}

	@Override
	public int update(long id, Share object) {
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
		
		return  db.delete(keys.TABLE	, "id = ?", new String[]{String.valueOf(id)});
		
	
	}
	@Override
	public List<Share> getAll() {
		// TODO Auto-generated method stub
		List<Share> shares = new ArrayList<Share>();
		
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID, null);
		if(c.moveToFirst()){
			do{
				Share share = new Share();
				share.setId(c.getLong(c.getColumnIndex(keys.ID)));
				share.setServer_amount_invested(c.getLong(c.getColumnIndex(keys.SERVER_AMOUNT_INVESTED)));
				share.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				share.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				share.setServer_share_added_date(c.getString(c.getColumnIndex(keys.SERVER_SHARED_ADDED_DATE)));
				share.setServer_share_value(c.getDouble(c.getColumnIndex(keys.SERVER_SHARE_VALUE)));
				share.setServer_status(c.getInt(c.getColumnIndex(keys.SERVER_STATUS)));
				share.setServer_total_share_purchased(c.getLong(c.getColumnIndex(keys.SERVER_TOTAL_SHARE_PURCHASED)));
				shares.add(share);
			}while(c.moveToNext());
		}
		
		return shares;
	}
	@Override
	public List<Share> getAllByLimit(int offset, int limit) {
		// TODO Auto-generated method stub
		if(offset < 0 || limit < 0){
			return getAll();
		}
		
		List<Share> shares = new ArrayList<Share>();
		
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID + " LIMIT ?,?", new String[]{offset+"",limit+""});
		if(c.moveToFirst()){
			do{
				Share share = new Share();
				share.setId(c.getLong(c.getColumnIndex(keys.ID)));
				share.setServer_amount_invested(c.getLong(c.getColumnIndex(keys.SERVER_AMOUNT_INVESTED)));
				share.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				share.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				share.setServer_share_added_date(c.getString(c.getColumnIndex(keys.SERVER_SHARED_ADDED_DATE)));
				share.setServer_share_value(c.getDouble(c.getColumnIndex(keys.SERVER_SHARE_VALUE)));
				share.setServer_status(c.getInt(c.getColumnIndex(keys.SERVER_STATUS)));
				share.setServer_total_share_purchased(c.getLong(c.getColumnIndex(keys.SERVER_TOTAL_SHARE_PURCHASED)));
				shares.add(share);
			}while(c.moveToNext());
		}
		
		return shares;
	}

}
