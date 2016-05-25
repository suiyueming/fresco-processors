package jp.wasabeef.example.fresco;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.DraweeView;

public class MaskImage extends ViewGroup{
    private static final String TAG = "MaskImage";
    private float borderWidth;

    int SimpleDraweeViewWidth;
    int SimpleDraweeViewHeight;


    public MaskImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ViewGroup.MarginLayoutParams(p);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //如果是warp_content情况下，记录宽和高
        int width = 0;
        int height = 0;

        int childCount = this.getChildCount();
        for (int i=0; i<childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child
                    .getLayoutParams();
            // 当前子空间实际占据的宽度
            int childWidth = child.getMeasuredWidth() + lp.leftMargin
                    + lp.rightMargin;
            // 当前子空间实际占据的高度
            int childHeight = child.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;
            if(child.getClass() == com.facebook.drawee.view.SimpleDraweeView.class) {
                SimpleDraweeViewWidth = childWidth;
                SimpleDraweeViewHeight = childHeight;
            }
            width += childWidth;
            height += childHeight;

        }

        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth
                : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight
                : height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = this.getChildCount();
        Log.e(TAG, "l = " + l + " r = " + r + " t = " + t + " b = " + b);

        for (int i =0; i<childCount; i++) {
            View child = getChildAt(i);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child
                    .getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            Log.e(TAG, child.getClass().toString());
            if(child.getClass() == net.grobas.view.PolygonImageView.class) {
                child.layout((l + lp.leftMargin),
                        (t + lp.topMargin),
                        (l + lp.leftMargin + childWidth),
                        (t + lp.topMargin + childHeight));
            } else if (child.getClass() == LinearLayout.class){
                Log.e(TAG, "LinearLayout");

            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}


