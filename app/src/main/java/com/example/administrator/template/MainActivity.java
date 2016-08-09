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
import com.example.administrator.template.template8.TemplateActivity8;
import com.example.administrator.template.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_1=(Button)findViewById(R.id.bt_1);
        bt_2=(Button)findViewById(R.id.bt_2);
        bt_3=(Button)findViewById(R.id.bt_3);
        bt_4=(Button)findViewById(R.id.bt_4);
        bt_5=(Button)findViewById(R.id.bt_5);
        bt_6=(Button)findViewById(R.id.bt_6);
        bt_7=(Button)findViewById(R.id.bt_7);
        bt_8=(Button)findViewById(R.id.bt_8);
        bt_9=(Button)findViewById(R.id.bt_9);
        bt_10=(Button)findViewById(R.id.bt_10);


     test();
    }

 private  void  test(){
    bt_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,TemplateActivity_1.class);
            startActivity(intent);
        }
    });
     bt_2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent =new Intent(MainActivity.this,ContentActivity.class);
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
             startActivity(new Intent(MainActivity.this,GridViewActivity_.class));
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
             startActivity(new Intent(MainActivity.this,TemplateActivity8.class));
         }
     });
     bt_9.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(MainActivity.this,ScrollingActivity.class));
         }
     });


}


}
