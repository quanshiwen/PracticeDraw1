package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mPaint;

    public Practice11PieChartView(Context context) {
        this(context,null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }



    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(300,20,800,520,-60,60,true,mPaint);

        mPaint.setColor(Color.parseColor("#EE82EE"));
        canvas.drawArc(300,20,800,520,3,8,true,mPaint);

//        mPaint.setColor(Color.parseColor("#696969"));
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(300,20,800,520,14,5,true,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(300,20,800,520,22,60,true,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(300,20,800,520,85,95,true,mPaint);


        mPaint.setColor(Color.RED);
        canvas.drawArc(290,10,790,510,180,120,true,mPaint);


        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(45);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawText("饼图",510,650,mPaint);

        Path path  = new Path();
        path.moveTo(800, 270);
        path.rLineTo(100, 0);
        canvas.drawPath(path,mPaint);
        mPaint.setTextSize(25);
        canvas.drawText("Froyo",950,275,mPaint);



    }
}
