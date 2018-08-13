package app.viewapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Scroller;

/**
 * Created by xuqianqian on 2018/7/30.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {

    Scroller mScroller;
    int count = 0;
    public MyButton(Context context) {
        super(context);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }


    public void init(Context mContext){

        mScroller = new Scroller(mContext);
    }

    public void smoothScrollTo(int destX){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //1000ms 内滑向destX 效果就是慢慢滑动
        mScroller.startScroll(scrollX,0,delta,0,1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        count+=1;
        Log.i("xx","测量次数"+count);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
