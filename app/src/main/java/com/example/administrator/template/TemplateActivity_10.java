package com.example.administrator.template;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fixed.FixedListView;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EActivity(R.layout.activity_test_10)
public class TemplateActivity_10 extends AutoLayoutActivity {
    private Context context;

    @ViewById
    ImageView img_test_10_3;

    @ViewById
    TextView tv_test_10_2;

    @ViewById
    LinearLayout ll_test_10_1;

    @ViewById
    LinearLayout ll_test_10_2;

    @ViewById
    RelativeLayout rl_test_10_2;

    @ViewById
    FixedListView flv_test_10;

    CommonAdapter flv_test_10_adapter;

    @AfterViews
    void  afterViews(){
        context=TemplateActivity_10.this;
        String [] strings={"赵先生","钱先生","孙先生","李先生"};
        List<String> list=new ArrayList<>();
        list.addAll(Arrays.asList(strings));
        flv_test_10_adapter=new CommonAdapter<String>(context, R.layout.item_test_10_listview,list) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setText(R.id.tv_item_10_1,str);
            }
        };
        flv_test_10.setAdapter(flv_test_10_adapter);
        click();
    }

    public void click(){
        img_test_10_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "图片介绍", Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "出发时间", Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_10_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "行程介绍", Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "价格优惠信息", Toast.LENGTH_SHORT).show();
            }
        });

        rl_test_10_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "评论的详细列表", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
