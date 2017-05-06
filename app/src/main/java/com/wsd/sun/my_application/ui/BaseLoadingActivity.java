package com.wsd.sun.my_application.ui;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.wsd.sun.my_application.R;


public abstract class BaseLoadingActivity extends BaseActivity {
    private ViewGroup mContentView;
    private View mProgressBar;
    private View mErrorView;
    private View mEmptyView;
    private View[] mViews;
    protected int mPageNum = 1;
    protected int mTotalPage;

    protected static final int NO_TOOL_BAR = -1;

    protected void setFirstPage() {
        mPageNum = 1;
    }

    protected boolean isFirstPage() {
        return mPageNum == 1;
    }

    protected void increasePage() {
        mPageNum++;
    }

    protected boolean canLoadMore() {
        return mPageNum <= mTotalPage;
    }

    protected boolean isLastPage() {
        return mPageNum == mTotalPage;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_loading_root);
        mContentView = (ViewGroup) findViewById(R.id.base_content);
        mProgressBar = findViewById(R.id.base_progressbar);
        mErrorView = findViewById(R.id.base_error);
        mEmptyView = findViewById(R.id.base_empty);
        Button mErrorBtn= (Button) findViewById(R.id.base_error_btn);
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(getContentView(), mContentView, true);

        mViews = new View[]{mContentView, mProgressBar, mErrorView, mEmptyView};
        showView(mProgressBar);

        mErrorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
                showLoadingView();
            }
        });
        initToolBar(inflater);
        initView();
        initData();
    }

    private void initToolBar(final LayoutInflater inflater) {
        FrameLayout toolbar = (FrameLayout) findViewById(R.id.base_toolbar);
        if (NO_TOOL_BAR != getToolBarView()) {
            inflater.inflate(getToolBarView(), toolbar);
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(0, 0, 0, 0);
            mContentView.setLayoutParams(params);
        }
        initToolBarView();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getContentView();

    protected abstract void initToolBarView();

    @LayoutRes
    protected abstract int getToolBarView();

    protected abstract void loadData();

    public void showContentView() {
        showView(mContentView);
    }

    /**
     * 显示页面加载结果为空
     */
    public void showEmptyView(@StringRes int textRes1) {
        showEmptyView(0, textRes1, 0);
    }

    /**
     * 显示页面加载结果为空
     */
    public void showEmptyView(@DrawableRes int imageRes, @StringRes int textRes1) {
        showEmptyView(imageRes, textRes1, 0);
    }

    /**
     * 显示页面加载结果为空
     */
    public void showEmptyView(@DrawableRes int imageRes, @StringRes int textRes1, @StringRes int textRes2) {
        showView(mEmptyView);
        if (imageRes != 0) {
            ImageView image = (ImageView) mEmptyView.findViewById(R.id.base_empty_image);
            image.setVisibility(View.VISIBLE);
            image.setImageResource(imageRes);
        }
        if (textRes1 != 0) {
            TextView text1 = (TextView) mEmptyView.findViewById(R.id.base_empty_text1);
            text1.setVisibility(View.VISIBLE);
            text1.setText(textRes1);
        }
        if (textRes2 != 0) {
            TextView text2 = (TextView) mEmptyView.findViewById(R.id.base_empty_text2);
            text2.setVisibility(View.VISIBLE);
            text2.setText(textRes2);
        }
    }

    public void showErrorView() {
        showView(mErrorView);
    }

    public void showLoadingView() {
        showView(mProgressBar);
    }

    private void showView(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(View.VISIBLE);
        for (View v : mViews) {
            if (view != v) {
                v.setVisibility(View.GONE);
            }
        }
    }

}
