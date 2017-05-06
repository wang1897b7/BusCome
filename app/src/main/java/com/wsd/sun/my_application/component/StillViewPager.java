package com.wsd.sun.my_application.component;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class StillViewPager extends ViewPager {

    public boolean isPagingEnabled() {
        return pagingEnabled;
    }

    public void setPagingEnabled(final boolean pagingEnabled) {
        this.pagingEnabled = pagingEnabled;
    }

    private boolean pagingEnabled;

    public StillViewPager(final Context context) {
        super(context);
    }

    public StillViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return pagingEnabled && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return !pagingEnabled || super.onTouchEvent(ev);
    }
}