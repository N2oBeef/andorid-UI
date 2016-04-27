package com.example.administrator.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MyEdit extends AppCompatEditText {
    private final int CLEAR = R.drawable.clearfill;

    private Context mContext;
    private Bitmap mBitmap_clear;

    private ValueAnimator mAnimator_visible;
    public MyEdit(final Context context)
    {
        super(context);
        this.mContext = context;
        init(context);
    }

    public MyEdit(final Context context,final AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context);
    }

    private void init(Context context)
    {
        mBitmap_clear = createBitmap(CLEAR, context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        int right = 100;
        int left  = getScrollX();
        int top = 0;
        int bottom = 50;

        Rect rect = new Rect(left,top,right,bottom);
        canvas.drawBitmap(mBitmap_clear, null, rect, null);

        if (getScrollX() != 0)
            Toast.makeText(getContext(), String.valueOf(getScrollX()), Toast.LENGTH_SHORT).show();
    }

    public Bitmap createBitmap(int resources,Context context) {
        final Drawable drawable = ContextCompat.getDrawable(context, resources);
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrappedDrawable, getCurrentHintTextColor());
        return drawableToBitamp(wrappedDrawable);
    }

    private Bitmap drawableToBitamp(Drawable drawable)
    {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);


    }
}
