package com.createconvertmedia.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircularImageView extends ImageView {
	
	private int borderWidth = 4;
	private int viewWidth;
	private int viewHeight;
	private Bitmap image;
	private Paint paint;
	private Paint paintBorder;
	private BitmapShader shader;

	

	public CircularImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setUp();
	}

	public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		setUp();
	}

	public CircularImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setUp();
	}
	
	
	//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	//@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setUp(){
		paint = new Paint();
		paint.setAntiAlias(true);
		
		paintBorder = new Paint();
		setBorderColor(Color.WHITE);
		paintBorder.setAntiAlias(true);
		this.setLayerType(LAYER_TYPE_SOFTWARE, paintBorder);
        paintBorder.setShadowLayer(4.0f, 0.0f, 2.0f, Color.BLACK);
	}
	
	public void setBorderWidth(int width){
		this.borderWidth = width;
		invalidate();
	}
	
	public void setBorderColor(int borderColor){
		if(paintBorder != null){
			paintBorder.setColor(borderColor);
		}
		invalidate();
	}
	
	private void loadBitmap(){
		BitmapDrawable drawable = (BitmapDrawable) getDrawable();
		if(drawable != null){
			image = drawable.getBitmap();
		}
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		loadBitmap();
		
		if(image != null){
			shader = new BitmapShader(Bitmap.createScaledBitmap(image, canvas.getWidth(), canvas.getHeight(), false ) , Shader.TileMode.CLAMP , Shader.TileMode.CLAMP);
			paint.setShader(shader);
			int circleCenter = viewWidth / 2;
			
			canvas.drawCircle(circleCenter + borderWidth , circleCenter + borderWidth, circleCenter + borderWidth - 4.0f, paintBorder);
			canvas.drawCircle(circleCenter + borderWidth , circleCenter + borderWidth , circleCenter - 4.0f, paint);
		
		}
		
		//super.onDraw(canvas);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		final int mWidth = (MeasureSpec.getMode(widthMeasureSpec)==MeasureSpec.EXACTLY)? MeasureSpec.getSize(widthMeasureSpec): viewWidth ;
		final int mHeight = ((MeasureSpec.getMode(heightMeasureSpec)==MeasureSpec.EXACTLY)? MeasureSpec.getSize(heightMeasureSpec): viewHeight ) + 2;
		viewWidth = mWidth - (borderWidth * 2);
		viewHeight = mHeight - (borderWidth * 2);
		
		setMeasuredDimension(mWidth , mHeight);
		
		//super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	

	
	
	
	
	
	

}
