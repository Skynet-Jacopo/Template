package com.example.administrator.template.TabHostAndViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuqun on 8/2/2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List<String> title;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        title =new ArrayList<>();
        title.add("端api");
        title.add("云api");
        title.add("文档");
        title.add("控制台");
        // TODO: 7/29/2016 这里添加tab,或减少tab
    }

    @Override
    public Fragment getItem(int position) {
//        if (position == 0){
            return ContentList1Fragment.getInstance(title.get(position));
//        }else{
//            return new SecondFragment();
//        }
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

