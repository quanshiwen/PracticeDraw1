package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private  static int [] colheghts = {490,480,480,250,150,100,300};
    private  static String[] texts = {"Froyo","GB","ICS","JB","KitKat","L","M"};

    public Practice10HistogramView(Context context) {
        this(context,null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }



    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.setStrokeWidth(2);
        canvas.drawLine(100,20,100,500,mPaint);
        canvas.drawLine(100,500,1000,500,mPaint);

        int colWidth = getColWidth(900, 30, 7);
        mPaint.setTextSize(25);
        for(int i=0;i<texts.length;i++) {
           int ddd =  (100+(30*(i+1))+colWidth*i)+colWidth/2;
            canvas.drawText(texts[i],ddd,525,mPaint);
        }

        mPaint.setTextSize(50);
        canvas.drawText("直方图",500,650,mPaint);

        mPaint.setColor(Color.GREEN);
        for(int i=0;i<colheghts.length;i++) {
            canvas.drawRect(100+(30*(i+1))+colWidth*i,colheghts[i],100+(30*(i+1))+colWidth*(i+1),500,mPaint);
        }





    }

    /**
     *
     * @param width 总长
     * @param intervat 间隔
     * @param copies   份数
     * @return
     */
    private int getColWidth(int width,int intervat,int copies) {
        int copiesWidth = 0;
        copiesWidth = (width-(intervat*(copies+1)))/copies;
        return copiesWidth;

    }
}
