package com.createconvertmedia.tasks;

import java.lang.ref.WeakReference;

import com.createconvertmedia.commons.Utilities;
import com.createconvertmedia.investordashboard.R;



import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;


public class BitmapDownloaderTask extends AsyncTask<String , Void , Bitmap>{

	private static final String TAG = BitmapDownloaderTask.class.getSimpleName();

	private final int default_wh = 120;
	
	private final WeakReference<ImageView> imageRef;
	public BitmapDownloaderTask(ImageView view){
		this.imageRef = new WeakReference<ImageView>(view);
	}	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		
		//if(ConnectionDetector.isConnectedToInternet(context))
		
		super.onPreExecute();
		if(imageRef != null){
			ImageView imageView = imageRef.get();
			imageView.setImageResource(R.drawable.ic_launcher);
		}
	}



	@Override
	protected Bitmap doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		return Utilities.downloadBitmap(arg0[0] );
	}
	
    @Override
    // Once the image is downloaded, associates it to the imageView
    protected void onPostExecute(Bitmap bitmap) {
    	if(imageRef == null) return;
    	
    	ImageView imageView = imageRef.get();
    	
    	if(imageView == null) return ;
    	
    	int w = imageView.getWidth();
    	int h = imageView.getHeight();
    	
    	
    	/*
    	 *  creating bitmap fonts that require width and height needs values
    	 *  for width and height greater than zero
    	 *  well fetch imageView width and height but this is asynchronous task
    	 *  depends if the imageview is already null we have to make sure
    	 */
    	if(w < 1){
    		w = default_wh;
    	}
    	if(h < 1){
    		h = default_wh;
    	}
    	
        if (isCancelled()) {
            bitmap = null;
            return;
        }
        
        if (bitmap == null){
        	return;
        }

        if (imageRef != null) {
            
            if (imageView != null ) {

                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, w, h, false));
            }
        }
    }

}
