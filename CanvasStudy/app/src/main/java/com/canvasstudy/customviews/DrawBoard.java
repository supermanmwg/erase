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
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mwg on 16-6-12.
 */
public class DrawBoard extends View {
    private Paint mPaint;
    private Path mPath;
    private Canvas mCanvas;
    private Bitmap mBitmap;
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
        mBitmap = Bitmap.createBitmap(400, 600, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

    }

      public void setPaint(int style) {
          if(style == 1) {
              mPath.reset();
              mPaint.reset();
              mPaint.setAntiAlias(true);
              mPaint.setStyle(Paint.Style.STROKE);
              mPaint.setStrokeWidth(10);
          } else if(style == 0) {
              mPaint.reset();
              mPaint.setAntiAlias(true);
              mPaint.setAlpha(0);
              mPaint.setColor(Color.WHITE);
              mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
              mPaint.setStyle(Paint.Style.STROKE);
              mPaint.setStrokeWidth(10);
          }
      }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                mCanvas.drawPath(mPath, mPaint);
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
