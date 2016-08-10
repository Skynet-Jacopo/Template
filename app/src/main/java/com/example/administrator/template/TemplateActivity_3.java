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
import com.example.administrator.template.fixed.FixedGridView;
import com.example.administrator.template.fragment.Fragment_3;
import com.example.administrator.template.fragment.Fragment_3_;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.utils.AutoUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EActivity(R.layout.activity_test_3)
public class TemplateActivity_3 extends AutoLayoutActivity {
    private Context context;
    @ViewById
    FixedGridView fgv_test_1;

    @ViewById
    FixedGridView fgv_test_2;

    @ViewById
    FixedGridView fgv_test_3;

    @ViewById
    TabLayout tablayout_tset_3;

    @ViewById
    ViewPager vp_test_3;

    CommonAdapter fgv_test_1_adapter;

    CommonAdapter fgv_test_2_adapter;

    CommonAdapter fgv_test_3_adapter;


    private FragmentStatePagerAdapter fragmentPagerAdapter;

    private List<Fragment> listFragments;
    private List<String>   listTitles;

    private Fragment_3 fragment1;
    private Fragment_3 fragment2;
    private Fragment_3 fragment3;


    private String[] test = {"美食", "电影", "酒店", "KTV", "足疗", "丽人", "门票", "购物", "全部"};
    List<String> gridview_1 = new ArrayList<>();

    private  Integer [] test_2={R.drawable.tuijian, R.drawable.tuijian, R.drawable.tuijian};
     List <Integer> gridview_2 =new ArrayList<>();


    private  Integer [] test_3={R.drawable.tuijian, R.drawable.tuijian};
    List <Integer> gridview_3 =new ArrayList<>();

    @AfterViews
    void afterViews() {
        context = TemplateActivity_3.this;
        initData();

        listFragments=new ArrayList<>();
        fragment1=new Fragment_3_();
        fragment2=new Fragment_3_();
        fragment3=new Fragment_3_();

        listFragments.add(fragment1);
        listFragments.add(fragment2);
        listFragments.add(fragment3);


        listTitles=new ArrayList<>();
        listTitles.add("为你精选");
        listTitles.add("附近最热");
        listTitles.add("今日最新");

        for (String title : listTitles) {
            tablayout_tset_3.addTab(tablayout_tset_3.newTab().setText(title));
        }
        fragmentPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), listFragments, listTitles);

        //viewpager加载adapter
        vp_test_3.setAdapter(fragmentPagerAdapter);
        //tablayout_store.setViewPager(vp_store_list);
        //TabLayout加载viewpager
        tablayout_tset_3.setupWithViewPager(vp_test_3);
        //tablayout_store.set
        tablayout_tset_3.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(context,tab.getText()+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    void initData(){
        gridview_1.addAll(Arrays.asList(test));
        gridview_2.addAll(Arrays.asList(test_2));
        gridview_3.addAll(Arrays.asList(test_3));
        fgv_test_1_adapter = new CommonAdapter<String>(context, R.layout.item_test_3_gridview, gridview_1) {
            @Override
            protected void onConvertViewCreated(View convertView) {
                AutoUtils.autoSize(convertView);
            }

            @Override
            public void convert(ViewHolder holder, String str) {

                holder.setText(R.id.textview_test_3, str);
            }
        };
        fgv_test_1.setAdapter(fgv_test_1_adapter);
        fgv_test_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,gridview_1.get(position),Toast.LENGTH_SHORT).show();
            }
        });





        fgv_test_2_adapter=new CommonAdapter<Integer>(context, R.layout.item_test_3_gridview_2,gridview_2) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                holder.setImageResource(R.id.img_test_3,integer);
            }
        };
        fgv_test_2.setAdapter(fgv_test_2_adapter);
        fgv_test_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"点击了第"+position+"个",Toast.LENGTH_SHORT).show();
            }
        });


        fgv_test_3_adapter=new CommonAdapter<Integer>(context, R.layout.item_test_3_gridview_3,gridview_3) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                holder.setImageResource(R.id.img_test_3,integer);
            }
        };
        fgv_test_3.setAdapter(fgv_test_3_adapter);
        fgv_test_3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"点击了第"+position+"个",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
