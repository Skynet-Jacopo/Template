package com.example.administrator.template;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fixed.FixedGridView;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EActivity(R.layout.activity_test_6)
public class TemplateActivity_6 extends AutoLayoutActivity {
    private Context context;
    @ViewById
    FixedGridView fgv_test_6;

    @ViewById
    ImageView img_test_6;

    @ViewById
    TextView tv_test_6_3;

    @ViewById
    TextView tv_test_6_4;

    @ViewById
    LinearLayout ll_test_6_1;

    @ViewById
    LinearLayout ll_test_6_2;

    @ViewById
    LinearLayout ll_test_6_3;

    @ViewById
    LinearLayout ll_test_6_4;

    @ViewById
    LinearLayout ll_test_6_5;



    CommonAdapter fgv_test_6_adapter;


    Integer[] img = {R.drawable.qq, R.drawable.qzone, R.drawable.weixin,
            R.drawable.friend, R.drawable.computer, R.drawable.cosmetology
            , R.drawable.education, R.drawable.dress
    };

    String [] info={"全部订单","天猫会员","收藏商品","天猫卡","优惠券","会员卡","天猫客服","合作商家"};
    List<Integer> gridview = new ArrayList<>();

    @AfterViews
    void afterViews() {
        context = TemplateActivity_6.this;
        gridview.addAll(Arrays.asList(img));
        fgv_test_6_adapter = new CommonAdapter<Integer>(context, R.layout.item_test_6_gridview, gridview) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                int postion=gridview.indexOf(integer);
                holder.setImageResource(R.id.img_test_3, integer);
                holder.setText(R.id.tv_test_6,info[postion]);
                holder.setText(R.id.tv_test_6_2,info[postion]);
            }
        };
        fgv_test_6.setAdapter(fgv_test_6_adapter);
        fgv_test_6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,info[position],Toast.LENGTH_SHORT).show();
            }
        });


        img_test_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"信息",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"登录",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"设置",Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"预付款",Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"特约价",Toast.LENGTH_SHORT).show();
            }
        });


        ll_test_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"特惠价",Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"特低价",Toast.LENGTH_SHORT).show();
            }
        });

        ll_test_6_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"价格/比值",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
