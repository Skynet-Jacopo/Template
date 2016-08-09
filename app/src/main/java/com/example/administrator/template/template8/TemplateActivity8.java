package com.example.administrator.template.template8;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class TemplateActivity8 extends AutoLayoutActivity implements ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {


    private ViewPager vpPager;
    private ImageView ivP1;
    private ImageView ivP2;
    private ImageView ivP3;
    private ImageView ivP4;
    private ImageView ivPrivilege;
    private TextView  tvPrivilegeName;
    private TextView  tvPrivilegeDes;
    private ImageView ivGroupBuy;
    private TextView  tvGroupBuyName;
    private TextView  tvGroupBuyDes;
    private ListView  mNormalLvItem;
    private ListView  mUnnormalLvItem;

    private ArrayList<View> list;
    int[] pics = {R.drawable.xiaoguo, R.drawable.xiaoguo, R.drawable.xiaoguo, R.drawable.xiaoguo};
    //四个点
    private ImageView[] points = new ImageView[4];

    private List<String> mNormalDatas;//假数据
    private List<String> mUnnormalDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template8);
        initPoint();
        initView();
    }

    private void initPoint() {
        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        points[3] = (ImageView) findViewById(R.id.iv_p4);
        setPoint(0);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setImageResource(R.drawable.point_green);
//                points[i].setImageAlpha(300);
            } else {
                points[i].setImageResource(R.drawable.point_orange);
//                points[i].setImageAlpha(100);
            }
        }
    }

    private void initView() {
        vpPager = (ViewPager) findViewById(R.id.vp_pager);
        ivPrivilege = (ImageView) findViewById(R.id.iv_privilege);
        tvPrivilegeName = (TextView) findViewById(R.id.tv_privilege_name);
        tvPrivilegeDes = (TextView) findViewById(R.id.tv_privilege_des);
        ivGroupBuy = (ImageView) findViewById(R.id.iv_group_buy);
        tvGroupBuyName = (TextView) findViewById(R.id.tv_group_buy_name);
        tvGroupBuyDes = (TextView) findViewById(R.id.tv_group_buy_des);
        mNormalLvItem = (ListView) findViewById(R.id.lv_item);
        mUnnormalLvItem = (ListView) findViewById(R.id.lv_unnormal_item);
        list = new ArrayList<View>();
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            //填充整个屏幕
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(pics[i]);
            list.add(iv);
        }
        vpPager.setAdapter(new MyPagerAdapter(list));
        vpPager.addOnPageChangeListener(this);

        mUnnormalDatas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mUnnormalDatas.add("满20减" + i);
        }
        ItemUnnormalAdapter itemUnnormalAdapter = new ItemUnnormalAdapter(this, mUnnormalDatas);
        itemUnnormalAdapter.notifyDataSetChanged();
        mUnnormalLvItem.setAdapter(itemUnnormalAdapter);

        mNormalDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mNormalDatas.add("【" + i + "店铺】测试数据");
        }
        ItemNormalAdapter adapter = new ItemNormalAdapter(this, mNormalDatas);
        adapter.notifyDataSetChanged();
        mNormalLvItem.setAdapter(adapter);
        //分别测量两个ListView的总高度,使界面显示完整
        ListViewUtility.setListViewHeightBasedOnChildren(mNormalLvItem);
        ListViewUtility.setListViewHeightBasedOnChildren(mUnnormalLvItem);
        mNormalLvItem.setOnItemClickListener(this);
        mUnnormalLvItem.setOnItemClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setPoint(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(TemplateActivity8.this, "点击了"+parent.getAdapter().getClass().getName()
                    +"的" +parent.getAdapter().getItemId(position), Toast.LENGTH_SHORT).show();


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
