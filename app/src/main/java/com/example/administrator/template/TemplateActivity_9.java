package com.example.administrator.template;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

@EActivity(R.layout.activity_test_9)
public class TemplateActivity_9 extends AutoLayoutActivity {
    private Context context;

    @ViewById
    FixedGridView fgv_test_9;

    @ViewById
    ImageView img_1_test_9;

    @ViewById
    LinearLayout ll_1_test_9;

    @ViewById
    LinearLayout ll_2_test_9;

    @ViewById
    LinearLayout ll_3_test_9;

    @ViewById
    LinearLayout ll_4_test_9;

    @ViewById
    LinearLayout ll_5_test_9;

    @ViewById
    LinearLayout ll_6_test_9;

    @ViewById
    LinearLayout ll_7_test_9;

    @ViewById
    LinearLayout ll_8_test_9;

    @ViewById
    LinearLayout ll_9_test_9;

    @ViewById
    LinearLayout ll_10_test_9;

    CommonAdapter fgv_test_9_adapter;

    Integer[] integers={R.drawable.qzone, R.drawable.qq, R.drawable.weixin};
    String [] name={"我的衣橱","专属试用","穿戴Style"};
    String [] detail={"私人时尚衣橱","只属于你的试用","不一样的风格"};

    List<Integer> list=new ArrayList<>();
    @AfterViews
    void afterViews() {
        context=TemplateActivity_9.this;
        list.addAll(Arrays.asList(integers));

        fgv_test_9_adapter=new CommonAdapter<Integer>(context, R.layout.item_test_4_listview,list) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                int postion =list.indexOf(integer);
                holder.setImageResource(R.id.img_test_3,integer);
                holder.setText(R.id.tv_test_9_1,name[postion]);
                holder.setText(R.id.tv_test_9_2,detail[postion]);
            }
        };
        fgv_test_9.setAdapter(fgv_test_9_adapter);
        fgv_test_9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,name[position],Toast.LENGTH_SHORT).show();

            }
        });

        click();
    }

    public  void click(){
        img_1_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "图片信息", Toast.LENGTH_SHORT).show();
            }
        });

        ll_1_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "积分", Toast.LENGTH_SHORT).show();
            }
        });
        ll_2_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "充值", Toast.LENGTH_SHORT).show();
            }
        });
        ll_3_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "彩票", Toast.LENGTH_SHORT).show();
            }
        });
        ll_4_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "上头条", Toast.LENGTH_SHORT).show();
            }
        });
        ll_5_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "天猫头条", Toast.LENGTH_SHORT).show();
            }
        });
        ll_6_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "品牌街", Toast.LENGTH_SHORT).show();
            }
        });
        ll_7_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "不一样的你", Toast.LENGTH_SHORT).show();
            }
        });
        ll_8_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "瞄一瞄", Toast.LENGTH_SHORT).show();
            }
        });
        ll_9_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "图片信息", Toast.LENGTH_SHORT).show();
            }
        });
        ll_10_test_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "名字", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
