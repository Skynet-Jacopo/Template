package com.example.administrator.template;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_test_7)
public class TemplateActivity_7 extends AutoLayoutActivity {
    private Context context;

    @ViewById
    ImageView img_test_7;

    @ViewById
    TextView tv_test_7_1;

    @ViewById
    TextView tv_test_7_2;

    @ViewById
    TextView tv_test_7_3;

    @ViewById
    TextView tv_test_7_4;

    @ViewById
    TextView tv_test_7_5;

    @ViewById
    TextView tv_test_7_6;

    @ViewById
    TextView tv_test_7_7;

    @ViewById
    TextView tv_test_7_8;

    @ViewById
    TextView tv_test_7_9;

    @ViewById
    TextView tv_test_7_10;

    @ViewById
    RelativeLayout rl_test_7;




    @AfterViews
    void afterViews() {
        context=TemplateActivity_7.this;

        img_test_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"头像",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"登录",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"常用地",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我的订单",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我的团购券",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我的收藏",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"最近浏览",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"待点评",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"服务中心",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"联系电话",Toast.LENGTH_SHORT).show();
            }
        });

        tv_test_7_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我的订单",Toast.LENGTH_SHORT).show();
            }
        });

        
        rl_test_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我的钱包",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
