package com.example.administrator.template.CoordinatorLayout;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AutoLayoutActivity implements View.OnClickListener,
        ScrollingRecyclerViewAdapter.OnRecyclerViewListener {

    private AppBarLayout            appBar;
    private CollapsingToolbarLayout toolbarLayout;
    private ImageView               ivBack;
    private ImageView               ivHead;
    private TextView                tvLogin;
    private ImageView               ivSetting;
    private LinearLayout            llayoutRead;
    private LinearLayout            llayoutStore;
    private LinearLayout            llayoutFollow;
    private RecyclerView            mRecyclerView;
    private LinearLayout            llayoutIde;
    private LinearLayout            llayoutTuoguan;
    private LinearLayout            llayoutPush;
    private LinearLayout            llayoutCount;
    private LinearLayout            llayoutSecurity;

    private List<String> datas = new ArrayList<>();
    private ScrollingRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置toolbar高度
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.getLayoutParams().height = getAppBarHeight();
            toolbar.setPadding(toolbar.getPaddingLeft(), getStatusBarHeight(),
                    toolbar.getPaddingRight(), toolbar.getPaddingBottom());
        }
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.tab_hot_select);
        initView();
        initEvent();
    }

    private void initView() {
        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        tvLogin = (TextView) findViewById(R.id.tv_login);
        ivSetting = (ImageView) findViewById(R.id.iv_setting);
        llayoutRead = (LinearLayout) findViewById(R.id.llayout_read);
        llayoutStore = (LinearLayout) findViewById(R.id.llayout_store);
        llayoutFollow = (LinearLayout) findViewById(R.id.llayout_follow);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        llayoutIde = (LinearLayout) findViewById(R.id.llayout_ide);
        llayoutTuoguan = (LinearLayout) findViewById(R.id.llayout_tuoguan);
        llayoutPush = (LinearLayout) findViewById(R.id.llayout_push);
        llayoutCount = (LinearLayout) findViewById(R.id.llayout_count);
        llayoutSecurity = (LinearLayout) findViewById(R.id.llayout_security);

        if (mRecyclerView != null) {
            //在回收时可以提高性能
            mRecyclerView.setHasFixedSize(true);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        for (int i = 0; i < 3; i++) {
            datas.add("测试" + i);
        }
        mAdapter = new ScrollingRecyclerViewAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnRecyclerViewListener(this);
    }


    private void initEvent() {
        ivBack.setOnClickListener(this);
        ivHead.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        ivSetting.setOnClickListener(this);
        llayoutRead.setOnClickListener(this);
        llayoutStore.setOnClickListener(this);
        llayoutFollow.setOnClickListener(this);
        llayoutIde.setOnClickListener(this);
        llayoutTuoguan.setOnClickListener(this);
        llayoutPush.setOnClickListener(this);
        llayoutCount.setOnClickListener(this);
        llayoutSecurity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_head:
                Toast.makeText(ScrollingActivity.this, "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_setting:
                Toast.makeText(ScrollingActivity.this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_login:
                Toast.makeText(ScrollingActivity.this, "登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_read:
                Toast.makeText(ScrollingActivity.this, "阅读", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_store:
                Toast.makeText(ScrollingActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_follow:
                Toast.makeText(ScrollingActivity.this, "跟帖", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_ide:
                Toast.makeText(ScrollingActivity.this, "IDE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_tuoguan:
                Toast.makeText(ScrollingActivity.this, "托管", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_push:
                Toast.makeText(ScrollingActivity.this, "推送", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_count:
                Toast.makeText(ScrollingActivity.this, "统计", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_security:
                Toast.makeText(ScrollingActivity.this, "安全", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            ScrollingActivity.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private int getAppBarHeight() {
        return dip2px(56) + getStatusBarHeight();
    }

    private int getStatusBarHeight() {
        int result     = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private int dip2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(ScrollingActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        Toast.makeText(ScrollingActivity.this, "长按了" + position, Toast.LENGTH_SHORT).show();
        return false;
    }

}
