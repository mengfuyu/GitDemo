package com.shared.thinkpad.mycliyeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**-
 * Created by ThinkPad on 2016/1/18.
 */
public class MyView extends ImageView {

    private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        roundImage(canvas);
    }


    public void roundImage(Canvas canvas){
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        Bitmap b = ((BitmapDrawable) drawable).getBitmap();

        if (null == b) {
            return;
        }

        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);

        if(isCheck){
            Paint paint = new Paint();
            //设置画笔颜色
            paint.setColor(0x905EA7E7);
            //设置圆弧的宽度
            paint.setStrokeWidth(8);
            //设置圆弧为空心
            paint.setStyle(Paint.Style.FILL);
            //消除锯齿
            paint.setAntiAlias(true);

            //获取圆心的x坐标
            int center = getWidth() / 2;
            int sX = center - getWidth() / 8;
            int sY = center - getWidth() / 10;
            int cX = sX - getWidth() / 10;
            int cY = center + getWidth() / 8;
            int eX = center + getWidth() / 5;
            int eY = center - getWidth() / 5;
            //圆弧半径
            int radius = getWidth() / 2;
            //画圆
            canvas.drawCircle(radius,radius,radius,paint);

            paint.setColor(Color.WHITE);

            //画第一根线
            canvas.drawLine(w/8*3,w/2,w/16*7+1,w/8*5,paint);

            canvas.drawLine(w/16*7-2,w/8*5,w/8*5,w/8*3,paint);
        }

    }



    public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        if (bmp.getWidth() != radius || bmp.getHeight() != radius)
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        else
            sbmp = bmp;
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffa19774;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f,
                sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }


//    Paint paint = null;
//    Paint paints = null;
//    private boolean falg = false;
//
//
//    public boolean isFalg() {
//        return falg;
//    }
//
//    public void setFalg(boolean falg) {
//        this.falg = falg;
//    }
//
//    public MyView(Context context) {
//        super(context);
//    }
//
//    public MyView(Context context, AttributeSet attrs) {
//
//        super(context, attrs);
//        paint = new Paint();
//        paints = new Paint();
//        paints.setARGB(80,65,105,255);
//        paints.setAntiAlias(true);
//        paint.setARGB(200,250,255,240);
//        paint.setStrokeWidth(5);
//
//    }
//
//    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if(falg){
//            getDraw(canvas);
//            falg = false;
//        }
//
//
//    }
//
//    public void getDraw(Canvas canvas){
//        canvas.drawCircle(160,130,120,paints);
//        canvas.drawLine(100,100,150,150,paint);
//        canvas.drawLine(150,150,230,90,paint);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//    }
}
