package com.example.administrator.template;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fixed.FixedGridView;
import com.example.administrator.template.fixed.FixedListView;
import com.example.administrator.template.gridviewgallery.GridViewGallery;
import com.example.administrator.template.gridviewgallery.GridViewItem;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EActivity(R.layout.activity_test_5)
public class TemplateActivity_5 extends AutoLayoutActivity {
    private Context context;


    @ViewById
    GridViewGallery grid_gallery;

    @ViewById
    FixedGridView fgv_test_5;

    @ViewById
    FixedListView flv_test_5;

    CommonAdapter fgv_test_5_adapter;
    CommonAdapter flv_test_5_adapter;

    List<GridViewItem> gridViewItems = new ArrayList<>();

    @AfterViews
    void afterViews() {
        context = TemplateActivity_5.this;
        initData();


    }


    void initData() {
        Integer[] integers = {R.drawable.weibo, R.drawable.car, R.drawable.baby, R.drawable.dress, R.drawable.qq,
                R.drawable.friend, R.drawable.weixin, R.drawable.education, R.drawable.computer, R.drawable.department_store, R.drawable.cosmetology,};

        final String[] name = {"出差", "吃喝", "旅游", "玩乐", "健康", "生活", "健身", "娱乐", "锻炼", "旅行", "家居"};

        for (int i = 0; i < integers.length; i++) {
            GridViewItem item = new GridViewItem(name[i], integers[i], 0, new GridViewItem.onGridViewItemClickListener() {
                @Override
                public void ongvItemClickListener(int position) {
                    Toast.makeText(context,"你点击了"+name[position],Toast.LENGTH_SHORT).show();
                }
            });
            gridViewItems.add(item);
        }
        grid_gallery.addGridItems(gridViewItems);

        Integer[] girdview = {R.drawable.qq, R.drawable.weixin, R.drawable.friend, R.drawable.qzone};
        final String [] name_test ={"免费吃喝玩","免费看电影","食色性也","点评祝福"};
        final String [] detail_test ={"新用户专享","新用户专享","光棍节等你来","单身用户专享"};
        final List<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(girdview));

        fgv_test_5_adapter = new CommonAdapter<Integer>(context, R.layout.item_test_5_gridview, test) {
            @Override

            public void convert(ViewHolder holder, Integer integer) {
                int postion=test.indexOf(integer);
               holder.setImageResource(R.id.img_icon,integer);
                holder.setText(R.id.tv_name,name_test[postion]);
                holder.setText(R.id.tv_brief,detail_test[postion]);

            }
        };
        fgv_test_5.setAdapter(fgv_test_5_adapter);
        fgv_test_5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,name_test[position],Toast.LENGTH_SHORT).show();
            }
        });

       final String [] test_2={"测试1","测试2","测试3","测试4","测试5"};

        List<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(test_2));

        flv_test_5_adapter=new CommonAdapter<String>(context, R.layout.item_test_3_listview,list) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setText(R.id.tv_item_3,str);
            }
        };
        flv_test_5.setAdapter(flv_test_5_adapter);
        flv_test_5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"你点击了"+test_2[position],Toast.LENGTH_SHORT).show();
            }
        });

    }

}
