package com.canvasstudy.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mwg on 16-6-12.
 */
public class DrawBoard extends View {
    private static final String TAG = "DrawBoard";
    private Paint mPaint;
    private Paint mPaint2;
    private Path mPath;
    private Path mPath2;
    private Canvas mCanvas;
    private Bitmap mBitmap;
    private int style = 1;
    public DrawBoard(Context context) {
        this(context, null);
    }

    public DrawBoard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPath = new Path();

        mPaint2 = new Paint();
        mPaint2.setAntiAlias(true);
       // mPaint2.setAlpha(0);
      //  mPaint2.setColor(Color.WHITE);
        mPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeWidth(30);
        mPath2 = new Path();
        mBitmap = Bitmap.createBitmap(400, 600, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

    }

      public void setPaint(int style) {
         this.style = style;
          Log.d(TAG, "style is " + style);
      }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if(style == 1) {
                    mPath.moveTo(x, y);
                } else {
                    mPath2.moveTo(x,y);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(style == 1) {
                    mPath.lineTo(x, y);
                    mCanvas.drawPath(mPath, mPaint);
                } else {
                    Log.d(TAG, "0");
                    mPath2.lineTo(x, y);
                    mCanvas.drawPath(mPath2, mPaint2);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}
