package com.example.administrator.template.TabHostAndViewPager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.template.R;
import com.example.administrator.template.TabLayoutAndViewPager.ContentListFragment;

import java.util.ArrayList;

public class ContentList1Fragment extends Fragment implements ViewPager.OnPageChangeListener {

    private ArrayList<View> list;
    int[] pics = {R.drawable.xiaoguo, R.drawable.xiaoguo, R.drawable.xiaoguo,
            R.drawable.xiaoguo, R.drawable.xiaoguo, R.drawable.xiaoguo};
    //6个点
    private ImageView[] points = new ImageView[6];
    private ViewPager vpPager;
    private TextView tvTitle;
    private RecyclerView recyclerView;

    public static ContentList1Fragment getInstance(String title) {
        ContentList1Fragment fragment = new ContentList1Fragment();
        Bundle              bundle   = new Bundle();
        bundle.putSerializable("key_language", title);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contentlist1, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vpPager = (ViewPager) view.findViewById(R.id.vp_pager);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        
        points[0] = (ImageView) view.findViewById(R.id.iv_p1);
        points[1] = (ImageView) view.findViewById(R.id.iv_p2);
        points[2] = (ImageView) view.findViewById(R.id.iv_p3);
        points[3] = (ImageView) view.findViewById(R.id.iv_p4);
        points[4] = (ImageView) view.findViewById(R.id.iv_p5);
        points[5] = (ImageView) view.findViewById(R.id.iv_p6);
        setPoint(0);
        list = new ArrayList<View>();
        vpPager = (ViewPager) view.findViewById(R.id.vp_pager);
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(getContext());
            //填充整个屏幕
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(pics[i]);
            list.add(iv);
        }
        vpPager.setAdapter(new MyPagerAdapter(list));
        vpPager.addOnPageChangeListener(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setImageResource(R.drawable.point_green);
            } else {
                points[i].setImageResource(R.drawable.point_orange);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //实现6个点和图片的联动
        setPoint(position);
    }

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
}
