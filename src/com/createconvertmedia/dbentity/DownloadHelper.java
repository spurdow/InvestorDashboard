package com.createconvertmedia.dbentity;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.createconvertmedia.entity.Pdf_download;
import com.createconvertmedia.iface.IHelperActions;

public class DownloadHelper implements IHelperActions<Pdf_download>{

	private static final String TAG = DownloadHelper.class.getSimpleName();
	private Context mContext;
	private final Pdf_download.DatabaseKey keys = new Pdf_download.DatabaseKey();
	
	public DownloadHelper(Context context){
		this.mContext = context;
	}
	
	@Override
	public long add(Pdf_download object) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(keys.ID, object.getC_id());
		values.put(keys.SERVER_ID, object.getServer_id());
		values.put(keys.SERVER_PDF_TITLE, object.getServer_pdf_title());
		values.put(keys.SERVER_PDF_FILE_NAME, object.getServer_pdf_file_name());
		values.put(keys.SERVER_PDF_ORIGINAL_NAME, object.getServer_pdf_original_name());
		values.put(keys.SERVER_CREATED, object.getServer_created());
		values.put(keys.SERVER_MODIFIED, object.getServer_modified());
		values.put(keys.SERVER_STATUS, object.getServer_status());
		
		try{
			return db.insertOrThrow(keys.TABLE, null, values);
		}catch(Exception ex){
			Log.w(TAG, "Cannot Insert error =  " + ex.getMessage());
		}
		
		return -1;
	}

	@Override
	public int update(long id, Pdf_download object) {
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
	public List<Pdf_download> getAll() {
		// TODO Auto-generated method stub
		List<Pdf_download> downloads = new ArrayList<Pdf_download>();
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID, null);
		if(c.moveToFirst()){
			do{
				Pdf_download download = new Pdf_download();
				download.setC_id(c.getLong(c.getColumnIndex(keys.ID)));
				download.setServer_id(c.getLong(c.getColumnIndex(keys.SERVER_ID)));
				download.setServer_pdf_title(c.getString(c.getColumnIndex(keys.SERVER_PDF_TITLE)));
				download.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				download.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				download.setServer_pdf_file_name(c.getString(c.getColumnIndex(keys.SERVER_PDF_FILE_NAME)));
				download.setServer_pdf_original_name(c.getString(c.getColumnIndex(keys.SERVER_PDF_ORIGINAL_NAME)));
				download.setServer_status(c.getString(c.getColumnIndex(keys.SERVER_STATUS)));
				downloads.add(download);
			}while(c.moveToNext());
		}
		
		return downloads;
	}

	@Override
	public List<Pdf_download> getAllByLimit(int offset, int limit) {
		// TODO Auto-generated method stub
		if(offset < 0 || limit < 0){
			return getAll();
		}
		List<Pdf_download> downloads = new ArrayList<Pdf_download>();
		SQLiteDatabase db = DatabaseHandler.getInstance(mContext).getReadableDatabase();
		Cursor c = db.rawQuery("SELECT * FROM " + keys.TABLE + " ORDER BY " + keys.ID + " LIMIT ?,? ", new String[]{offset+"",limit+""});
		if(c.moveToFirst()){
			do{
				Pdf_download download = new Pdf_download();
				download.setC_id(c.getLong(c.getColumnIndex(keys.ID)));
				download.setServer_id(c.getLong(c.getColumnIndex(keys.SERVER_ID)));
				download.setServer_pdf_title(c.getString(c.getColumnIndex(keys.SERVER_PDF_TITLE)));
				download.setServer_created(c.getString(c.getColumnIndex(keys.SERVER_CREATED)));
				download.setServer_modified(c.getString(c.getColumnIndex(keys.SERVER_MODIFIED)));
				download.setServer_pdf_file_name(c.getString(c.getColumnIndex(keys.SERVER_PDF_FILE_NAME)));
				download.setServer_pdf_original_name(c.getString(c.getColumnIndex(keys.SERVER_PDF_ORIGINAL_NAME)));
				download.setServer_status(c.getString(c.getColumnIndex(keys.SERVER_STATUS)));
				downloads.add(download);
			}while(c.moveToNext());
		}
		
		return downloads;
	}

}
