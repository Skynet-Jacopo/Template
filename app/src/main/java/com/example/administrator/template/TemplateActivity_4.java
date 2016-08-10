package com.example.administrator.template;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.abslistview.ViewPagerFragmentAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fragment.Fragment_3;
import com.example.administrator.template.fragment.Fragment_3_;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.finalteam.galleryfinal.widget.HorizontalListView;


@EActivity(R.layout.activity_test_4)
public class TemplateActivity_4 extends AutoLayoutActivity {
    private Context context;
    @ViewById
    HorizontalListView hlv_test_4;
    @ViewById
    TabLayout          tablayout_tset_4;
    @ViewById
    ViewPager          vp_test_4;
    CommonAdapter hlv_test_4_adapter;


    private FragmentStatePagerAdapter fragmentPagerAdapter;
    private List<Fragment>            listFragments;
    private List<String>              listTitles;

    private Fragment_3 fragment1;
    private Fragment_3 fragment2;
    private Fragment_3 fragment3;


    private Integer[] test_2 = {R.drawable.weibo, R.drawable.qzone,
            R.drawable.all, R.drawable.baby, R.drawable.computer,
            R.drawable.cosmetology, R.drawable.department_store, R.drawable.car,
            R.drawable.dress, R.drawable.education, R.drawable.hotel};
    private String[]  test_4 = {"饮食", "美酒", "生活", "健身", "娱乐", "冒险", "旅行", "观光", "游乐", "交通", "医院"};
    List<Integer> gridview_2 = new ArrayList<>();


    @AfterViews
    void afterViews() {
        context = TemplateActivity_4.this;
        initData();

        listFragments = new ArrayList<>();
        fragment1 = new Fragment_3_();
        fragment2 = new Fragment_3_();
        fragment3 = new Fragment_3_();

        listFragments.add(fragment1);
        listFragments.add(fragment2);
        listFragments.add(fragment3);


        listTitles = new ArrayList<>();
        listTitles.add("全部地区");
        listTitles.add("默认排序");
        listTitles.add("全部影院");

        for (String title : listTitles) {
            tablayout_tset_4.addTab(tablayout_tset_4.newTab().setText(title));
        }
        fragmentPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), listFragments, listTitles);

        //viewpager加载adapter
        vp_test_4.setAdapter(fragmentPagerAdapter);
        //tablayout_store.setViewPager(vp_store_list);
        //TabLayout加载viewpager
        tablayout_tset_4.setupWithViewPager(vp_test_4);
        tablayout_tset_4.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(context, tab.getText() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    void initData() {
        gridview_2.addAll(Arrays.asList(test_2));
        hlv_test_4_adapter = new CommonAdapter<Integer>(context, R.layout.item_test_4_horilistview, gridview_2) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                int postion = gridview_2.indexOf(integer);
                holder.setImageResource(R.id.img_test_3, integer);
                holder.setText(R.id.tv_item_4_listview, test_4[postion] + "");
            }
        };
        hlv_test_4.setAdapter(hlv_test_4_adapter);
        hlv_test_4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, test_4[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

}
