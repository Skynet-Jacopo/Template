package com.example.administrator.template;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.template.CoordinatorLayout.ScrollingActivity;
import com.example.administrator.template.EditText.EditTextActivity;
import com.example.administrator.template.GridView.GridViewActivity_;
import com.example.administrator.template.TabHostAndViewPager.TabHostActivity_;
import com.example.administrator.template.TabLayoutAndViewPager.ContentActivity;
import com.example.administrator.template.ToolBarAndRecyclerView.ToolBarActivity;
import com.example.administrator.template.pay.PayDemoActivity;
import com.example.administrator.template.template8.TemplateActivity8;
import com.example.administrator.template.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_10;
    private Button bt_11;
    private Button bt_12;
    private Button bt_13;
    private Button bt_14;
    private Button bt_15;
    private Button bt_16;
    private Button bt_17;
    private Button bt_18;
    private Button bt_19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
        bt_9 = (Button) findViewById(R.id.bt_9);
        bt_10 = (Button) findViewById(R.id.bt_10);
        bt_11 = (Button) findViewById(R.id.bt_11);
        bt_12 = (Button) findViewById(R.id.bt_12);
        bt_13 = (Button) findViewById(R.id.bt_13);
        bt_14 = (Button) findViewById(R.id.bt_14);
        bt_15 = (Button) findViewById(R.id.bt_15);
        bt_16 = (Button) findViewById(R.id.bt_16);
        bt_17 = (Button) findViewById(R.id.bt_17);
        bt_18 = (Button) findViewById(R.id.bt_18);
        bt_19 = (Button) findViewById(R.id.bt_19);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_10.setOnClickListener(this);
        bt_11.setOnClickListener(this);
        bt_12.setOnClickListener(this);
        bt_13.setOnClickListener(this);
        bt_14.setOnClickListener(this);
        bt_15.setOnClickListener(this);
        bt_16.setOnClickListener(this);
        bt_17.setOnClickListener(this);
        bt_18.setOnClickListener(this);
        bt_19.setOnClickListener(this);

    }

    private void test() {
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TemplateActivity_1.class);
                startActivity(intent);
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridViewActivity_.class));
            }
        });
        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
            }
        });
        bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditTextActivity.class));
            }
        });
        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TabHostActivity_.class));
            }
        });
        bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TemplateActivity8.class));
            }
        });
        bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                startActivity(new Intent(MainActivity.this, TemplateActivity_1.class));
                break;
            case R.id.bt_2:
                startActivity(new Intent(MainActivity.this, TemplateActivity_2.class));
                break;
            case R.id.bt_3:
                startActivity(new Intent(MainActivity.this, TemplateActivity_3_.class));
                break;
            case R.id.bt_4:
                startActivity(new Intent(MainActivity.this, TemplateActivity_4_.class));
                break;
            case R.id.bt_5:
                startActivity(new Intent(MainActivity.this, TemplateActivity_5_.class));
                break;
            case R.id.bt_6:
                startActivity(new Intent(MainActivity.this, TemplateActivity_6_.class));
                break;
            case R.id.bt_7:
                startActivity(new Intent(MainActivity.this, TemplateActivity_7_.class));
                break;
            case R.id.bt_8:
                startActivity(new Intent(MainActivity.this, TemplateActivity_8_.class));
                break;
            case R.id.bt_9:
                startActivity(new Intent(MainActivity.this, TemplateActivity_9_.class));
                break;
            case R.id.bt_10:
                startActivity(new Intent(MainActivity.this, TemplateActivity_10_.class));
                break;
            case R.id.bt_11:
                startActivity(new Intent(MainActivity.this, PayDemoActivity.class));
                break;
            case R.id.bt_12:
                startActivity(new Intent(MainActivity.this, ContentActivity.class));
                break;
            case R.id.bt_13:
                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
                break;
            case R.id.bt_14:
                startActivity(new Intent(MainActivity.this, GridViewActivity_.class));
                break;
            case R.id.bt_15:
                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                break;
            case R.id.bt_16:
                startActivity(new Intent(MainActivity.this, EditTextActivity.class));
                break;
            case R.id.bt_17:
                startActivity(new Intent(MainActivity.this, TabHostActivity_.class));
                break;
            case R.id.bt_18:
                startActivity(new Intent(MainActivity.this, TemplateActivity8.class));
                break;
            case R.id.bt_19:
                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
                break;
        }
    }
}
