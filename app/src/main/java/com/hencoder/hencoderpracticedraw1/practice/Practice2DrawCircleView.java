package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint mPaint;

    public Practice2DrawCircleView(Context context) {
        this(context,null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
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
         * drawCircle(float centerX, float centerY, float radius, Paint paint) 画圆
         * 前两个参数 centerX centerY 是圆心的坐标，第三个参数 radius 是圆的半径,坐标起点为
         * 屏幕左上角,向右为正x轴,向下为正呀轴
         */
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(300,150,150,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(750,150,150,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(300,500,150,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        canvas.drawCircle(750,500,150,mPaint);




    }

    private void initPaint() {
        mPaint = new Paint();
        //设置画笔颜色,用于绘制控件的颜色
        //mPaint.setStyle();//绘制模式,是实心还是空心,是否有边框
       // mPaint.setStrokeWidth();//绘制图形的边框宽度
        mPaint.setAntiAlias(true);//是否开启抗锯齿
    }
}
