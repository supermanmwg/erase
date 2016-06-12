package com.canvasstudy.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mwg on 16-6-12.
 */
public class CanvasView extends View {
    private Paint mPaint;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(100, 100);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, mPaint);
        canvas.restore();
        mPaint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, mPaint);
      /*  RectF rectF = new RectF(100, 100, 200, 200);
        int count1 = canvas.saveLayer(rectF, mPaint);
        canvas.drawCircle(0, 0, 200, mPaint);
        canvas.restoreToCount(count1);*/
    }
}
