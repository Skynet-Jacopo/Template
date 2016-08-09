package com.example.administrator.template.TabLayoutAndViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ContentPagerAdapter extends FragmentPagerAdapter {

    private final List<String> title;
    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
        title =new ArrayList<>();
        title.add("测试1");
        title.add("测试2");
        title.add("测试3");
        title.add("测试4");
        title.add("测试5");
        title.add("测试6");
        title.add("测试7");
        // TODO: 7/29/2016 这里添加tab,或减少tab
    }

    @Override
    public Fragment getItem(int position) {
        return ContentListFragment.getInstance(title.get(position));
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
