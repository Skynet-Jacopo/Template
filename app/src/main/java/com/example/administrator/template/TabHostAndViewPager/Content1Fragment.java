package com.example.administrator.template.TabHostAndViewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.template.R;

public class Content1Fragment extends Fragment  {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private MyPagerAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content1, null);
        //        TabLayout.Tab tab1 = mTabLayout.newTab().setText("Tab1");
//        mTabLayout.addTab(tab1);
//        TabLayout.Tab tab2 = mTabLayout.newTab().setText("Tab2");
//        mTabLayout.addTab(tab2);
        // TODO: 7/29/2016 当只有两个tab时平分屏幕


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        //平分屏幕
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

}
