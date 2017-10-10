package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint mPaint;

    public Practice9DrawPathView(Context context) {
        this(context,null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }



    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        /**
         * Path 方法第一类：直接描述路径。
         * 这一类方法还可以细分为两组：添加子图形和画线（直线或曲线）
         *
         * 第一组： addXxx() ——添加子图形
         * addCircle(float x, float y, float radius, Direction dir) 添加圆
         * x, y, radius 这三个参数是圆的基本信息，最后一个参数 dir 是画圆的路径的方向。
         * addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
         * addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
         * addRoundRect(RectF rect, float rx, float ry, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) / addRoundRect(RectF rect, float[] radii, Direction dir) / addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
         * addPath(Path path) 添加另一个 Path
         *
         * 第二组：xxxTo() ——画线（直线或曲线）
         *这一组和第一组 addXxx() 方法的区别在于，第一组是添加的完整封闭图形（除了 addPath() ），
         * 而这一组添加的只是一条线。
         *
         * lineTo(float x, float y) / rLineTo(float x, float y) 画直线
         *从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标。这两个方法的区别是，lineTo(x, y)
         * 的参数是绝对坐标，而 rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是 relatively
         * 「相对地」)。
         * quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
         * 这条二次贝塞尔曲线的起点就是当前位置，而参数中的 x1, y1 和 x2, y2 则分别是控制点和终点的坐标。
         * 和 rLineTo(x, y) 同理，rQuadTo(dx1, dy1, dx2, dy2) 的参数也是相对坐标
         *
         * cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) /
         * rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线
         *
         * moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
         * 不论是直线还是贝塞尔曲线，都是以当前位置作为起点，而不能指定起点。但你可以通过 moveTo(x, y)
         * 或 rMoveTo() 来改变当前位置，从而间接地设置这些方法的起点。
         *
         * 另外，第二组还有两个特殊的方法： arcTo() 和 addArc()。它们也是用来画线的，但并不使用当前位置作为弧线的起点。
         * arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)
         * / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo)
         * / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
         * 这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
         * 少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
         *
         * addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle)
         * / addArc(RectF oval, float startAngle, float sweepAngle)
         * 又是一个弧形的方法。一个叫 arcTo ，一个叫 addArc()，都是弧形，
         * 区别在哪里？其实很简单： addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo() 。
         *
         * close() 封闭当前子图形
         * 它的作用是把当前的子图形封闭，即由当前位置向当前子图形的起点绘制一条直线。
         *
         * 另外，不是所有的子图形都需要使用 close() 来封闭。
         * 当需要填充图形时（即 Paint.Style 为 FILL 或 FILL_AND_STROKE），Path 会自动封闭子图形。
         */

        Path path = new Path();
        path.addArc(300,200,500,400,-225,225);//添加一个弧形
       // path.arcTo(300,200,500,400,-180,180,false);
        path.arcTo(500,200,700,400,-180,225,false);
        path.lineTo(500,500);

        canvas.drawPath(path,mPaint);
    }
}
