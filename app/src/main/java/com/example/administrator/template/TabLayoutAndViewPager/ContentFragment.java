package com.example.administrator.template.TabLayoutAndViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.template.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liuqun on 6/30/2016.
 */
public class ContentFragment extends Fragment {

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private ContentPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
//        TabLayout.Tab tab1 = mTabLayout.newTab().setText("Tab1");
//        mTabLayout.addTab(tab1);
//        TabLayout.Tab tab2 = mTabLayout.newTab().setText("Tab2");
//        mTabLayout.addTab(tab2);
        // TODO: 7/29/2016 当只有两个tab时平分屏幕
        //平分屏幕
//        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new ContentPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
