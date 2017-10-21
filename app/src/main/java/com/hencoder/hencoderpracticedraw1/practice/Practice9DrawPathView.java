package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Practice9DrawPathView extends View {

    private Paint mPaint;
    private int color = Color.RED;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                color = Utils.randomColor();
                postInvalidate();
            }
        };
        new Timer().scheduleAtFixedRate(timerTask, 2000, 2000);
    }

    /**
     * 线长
     */


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        mPaint.setColor(color);


        int availableWidth = Math.min(getHeight(), getWidth());
        /**
         * 两个小圆的半径
         */
        int circleRadius = availableWidth / 8;
        /**
         * 整个图形的宽度
         */
        int shapeWidth = 4 * circleRadius;
        int lineLength = (int) (Math.tan(Utils.angleToRad(75)) * circleRadius);
        // 整个图形的高度
        int shapeHeight = circleRadius + lineLength;

        /**
         * 绘制左边凸起部分
         */
        Path path = new Path();
        path.arcTo(new RectF(0, 0, 2 * circleRadius, 2 * circleRadius), 150f, 210f);
        path.arcTo(new RectF(2 * circleRadius, 0, 4 * circleRadius, 2 * circleRadius),
                180f, 210f);
        path.lineTo(2f * circleRadius, lineLength);
        path.lineTo((float) (circleRadius - Math.cos(Utils.angleToRad(30)) * circleRadius),
                (float) (circleRadius + Math.sin(Utils.angleToRad(30)) * circleRadius));

        canvas.translate(getWidth()/4, getHeight()/4);
//        canvas.drawColor(Utils.randomColor());
        canvas.drawPath(path, mPaint);
        canvas.save();
    }

    private Path makeHeartPath() {
        Path path = new Path();

        float cX = getWidth() / 2f;
        float cY = getHeight() / 2f;
        float anchWidth = 200;
        path.lineTo(cX, cY + anchWidth);
        path.lineTo(cX - anchWidth, cY);
        path.lineTo(cX + anchWidth, cY);
        path.lineTo(cX, cY + anchWidth);
        path.addCircle(cX - anchWidth / 2f, cY - anchWidth / 2f, anchWidth / 2f, Path.Direction.CW);
        path.addCircle(cX + anchWidth / 2f, cY - anchWidth / 2f, anchWidth / 2f, Path.Direction.CW);
//        path.addCircle();
        return path;
    }
}
