package com.dmtaiwan.alexander.bibleshowdown.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Alexander on 12/4/2017.
 */

public class GamePager extends ViewPager {

    public GamePager(Context context) {
        super(context);
    }


    public GamePager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
