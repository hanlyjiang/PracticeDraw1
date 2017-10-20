package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        /**
         * 每个小圆的可用正方形的宽度
         */
        int cubeWidth = Math.min(getWidth() / 2, getHeight() / 2);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        float radius = cubeWidth / 2f - 40;
        canvas.drawCircle(getWidth() / 2f - cubeWidth / 2f, getHeight() / 2f - cubeWidth / 2f, radius, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth() / 2f + cubeWidth / 2f, getHeight() / 2f - cubeWidth / 2f, radius, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(getWidth() / 2f - cubeWidth / 2f, getHeight() / 2f + cubeWidth / 2f, radius, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        canvas.drawCircle(getWidth() / 2f + cubeWidth / 2f, getHeight() / 2f + cubeWidth / 2f, radius, paint);
    }
}
