package com.wsd.sun.my_application.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wsd.sun.my_application.Constants;
import com.wsd.sun.my_application.R;

import java.lang.reflect.Field;






public class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected String mSc = "";

    private ProgressDialog mDialog;

    public ProgressDialog newDialog() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("请稍候...");
        return mDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSc = getIntent().getStringExtra(Constants.EXTRA_SC);
        mContext = this;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
        super.onDestroy();
        fixInputMethodManager(this);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void initToolbar(int titleRes) {
        String title = getString(titleRes);
        initToolbar(title);
    }

    public void initToolbar(int titleRes, int backIconRes) {
        String title = getString(titleRes);
        initToolbar(title, backIconRes);
    }

    public void initToolbar(String title) {
        initToolbar(title, 0);
    }

    public void initToolbar(String title, int backIconRes) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.title);
        titleText.setText(title);
        setSupportActionBar(toolbar);
        setActionBar(toolbar, backIconRes);
    }

    public void initToolbar(String title, String rightMenu, final OnToolbarMenuClickListener listener) {
        initToolbar(title, 0, rightMenu, listener);
    }

    public void initToolbarWithRightMenuBg(String title, @DrawableRes int menuBg, final OnToolbarMenuClickListener
            listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.title);
        titleText.setText(title);
        TextView menuText = (TextView) toolbar.findViewById(R.id.toolbar_right_text_menu);
        menuText.setVisibility(View.VISIBLE);
        menuText.setBackgroundResource(menuBg);
        menuText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });
        setSupportActionBar(toolbar);
        setActionBar(toolbar, 0);
    }

    public void initToolbar(String title, int backIconRes, String rightMenu, final OnToolbarMenuClickListener
            listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.title);
        titleText.setText(title);
        TextView menuText = (TextView) toolbar.findViewById(R.id.toolbar_right_text_menu);
        menuText.setVisibility(View.VISIBLE);
        menuText.setText(rightMenu);
        menuText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });
        setSupportActionBar(toolbar);
        setActionBar(toolbar, backIconRes);
    }

    public void initToolbar(int titleRes, int rightMenuRes, final OnToolbarMenuClickListener listener) {
        initToolbar(getString(titleRes), getString(rightMenuRes), listener);
    }

    public void initToolbar(String title, int rightMenuRes, final OnToolbarMenuClickListener listener) {
        initToolbar(title, getString(rightMenuRes), listener);
    }

    private void setActionBar(Toolbar toolbar, int backIconRes) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(false);
            ab.setDisplayShowTitleEnabled(false);
            ImageView back = (ImageView) toolbar.findViewById(R.id.toolbar_back);
            if (backIconRes != 0) {
                back.setImageResource(backIconRes);
            } else {
                back.setImageResource(R.mipmap.ic_toolbar_back);
            }
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    onBackPressed();
                }
            });
        }
    }

    public void setTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleText = (TextView) toolbar.findViewById(R.id.title);
        titleText.setText(title);
    }

    public interface OnToolbarMenuClickListener {
        void onItemClick();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onToolbarBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onToolbarBackPressed() {
        onBackPressed();
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
    }


    /**
     * 修复 InputMethodManager 导致的内存溢出
     */
    private void fixInputMethodManager(Context context) {
        final Object imm = context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f;
        Object obj_get;
        for (String param : arr) {
            try {
                f = imm.getClass().getDeclaredField(param);
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get.getContext() == context) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        break;
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

}
