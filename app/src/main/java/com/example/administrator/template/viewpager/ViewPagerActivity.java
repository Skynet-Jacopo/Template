package com.example.administrator.template.viewpager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.example.administrator.template.ToolBarAndRecyclerView.MyAdapter;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AutoLayoutActivity implements ViewPager
        .OnPageChangeListener, MyAdapter.OnRecyclerViewListener, MyRecyclerViewAdapter.OnRecyclerViewListener {

    private ViewPager       pager;
    private ArrayList<View> list;
    int[] pics = {R.drawable.xiaoguo, R.drawable.xiaoguo, R.drawable.xiaoguo};
    //三个点
    private ImageView[] points = new ImageView[3];

    RecyclerView mRecyclerView;
    private List<String> datas = new ArrayList<>();//假数据
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //初始化3个点
        initPoints();
        //初始化ViewPager
        initView();
    }

    private void initPoints() {
        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        setPoint(0);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setImageResource(R.drawable.view_pager_selection_point_selection);
//                points[i].setImageAlpha(300);
            } else {
                points[i].setImageResource(R.drawable.view_pager_selection_point_normal);
//                points[i].setImageAlpha(100);
            }
        }
    }

    private void initView() {
        list = new ArrayList<View>();
        pager = (ViewPager) findViewById(R.id.vp_pager);
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            //填充整个屏幕
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(pics[i]);
            list.add(iv);
        }
        pager.setAdapter(new MyPagerAdapter(list));
        pager.addOnPageChangeListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if (mRecyclerView != null) {
            //在回收时可以提高性能
            mRecyclerView.setHasFixedSize(true);
        }
        GridLayoutManager manager =new GridLayoutManager(this,2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < 20; i++) {
            datas.add("测试" + i);
        }
        mAdapter = new MyRecyclerViewAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnRecyclerViewListener(this);
    }

    //界面切换时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //界面切换后调用
    @Override
    public void onPageSelected(int position) {
        //实现3个点和图片的联动
        setPoint(position);
    }

    //滑动状态变化时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //自定义MyPagerAdapter继承PagerAdapter
    private class MyPagerAdapter extends PagerAdapter {

        private ArrayList<View> list;

        public MyPagerAdapter(ArrayList<View> list) {
            this.list = list;
        }

        //初始化position 展现到界面上来
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position), 0);
            return list.get(position);
        }

        //当不可见时,销毁position
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public int getCount() {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
    @Override
    public void onItemClick(int position) {
        Toast.makeText(ViewPagerActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        Toast.makeText(ViewPagerActivity.this, "长按了"+position, Toast.LENGTH_SHORT).show();
        return false;
    }
}

