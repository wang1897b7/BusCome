package com.wsd.sun.my_application.component;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.wsd.sun.my_application.R;


public class SmartImageView extends android.support.v7.widget.AppCompatImageView {


    public SmartImageView(Context context) {
        super(context);
    }

    public SmartImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmartImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setImageUrl(String url) {
        setImage(url, 0, 0);
    }

    public void setImageUrl(String url, @DrawableRes int errorDrawable) {
        setImage(url, errorDrawable, 0);
    }

    public void setImageUrl(String url, @DrawableRes int errorDrawable, @DrawableRes int loadDrawable) {
        setImage(url, errorDrawable, loadDrawable);
    }

    private void setImage(String url, @DrawableRes int errorDrawable, @DrawableRes int loadDrawable) {
        if (TextUtils.isEmpty(url)) {
            setImageResource(R.mipmap.ic_launcher);
        } else {
            if (errorDrawable == 0) {
                errorDrawable = R.mipmap.ic_launcher;
            }
            if (loadDrawable == 0) {
                loadDrawable = R.mipmap.ic_launcher;
            }
            setScaleType(ScaleType.FIT_XY);
            if (getContext() != null) {
                Glide.with(getContext().getApplicationContext())
                        .load(url)
                        .fitCenter()
                        .placeholder(loadDrawable)
                        .error(errorDrawable)
                        .crossFade()
                        .into(this);
            }
            invalidate();
        }
    }

}