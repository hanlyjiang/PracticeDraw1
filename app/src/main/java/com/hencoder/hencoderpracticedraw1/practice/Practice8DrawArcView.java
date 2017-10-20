package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        RectF rectF = new RectF(getWidth() * 0.25f,
                getHeight() * 0.3f,
                getWidth() * 0.75f,
                getHeight() * 0.7f);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, 25, 130, false, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 180 + 25, 40, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 270 - 15, 90, true, paint);
    }
}
