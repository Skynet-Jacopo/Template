package com.example.administrator.template;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EActivity(R.layout.activity_test_8)
public class TemplateActivity_8 extends AutoLayoutActivity {
    private Context context;

    @ViewById
    ListView lv_test_8;

    CommonAdapter lv_test_8_adapter;
    int a=1;
    Integer[] integers = new Integer[20];
    SparseArray<Boolean> checkStates=new SparseArray<>();
    @AfterViews
    void afterViews() {
        context = TemplateActivity_8.this;
        final List<Integer> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            checkStates.put(i,false);
            integers[i]=i;
        }
        list.addAll(Arrays.asList(integers));


        lv_test_8_adapter = new CommonAdapter<Integer>(context, R.layout.item_test_8_listview, list) {
            @Override
            public void convert(ViewHolder holder, Integer integer) {
                final int postion=list.indexOf(integer);
                final CheckBox cb_1 = holder.getView(R.id.cb_test_8_1);
                final CheckBox cb_2 = holder.getView(R.id.cb_test_8_2);

                cb_1.setChecked(checkStates.valueAt(postion));
                cb_2.setChecked(checkStates.valueAt(postion));


                cb_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a == 1) {
                            cb_1.setChecked(true);
                            cb_2.setChecked(true);
                            checkStates.setValueAt(postion,true);
                            a = 0;
                        } else {
                            cb_1.setChecked(false);
                            cb_2.setChecked(false);
                            checkStates.setValueAt(postion,false);
                            a=1;

                        }
                    }
                });

                cb_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (a == 1) {
                            cb_1.setChecked(true);
                            cb_2.setChecked(true);
                            checkStates.setValueAt(postion,true);
                            a = 0;
                        } else {
                            cb_1.setChecked(false);
                            cb_2.setChecked(false);
                            checkStates.setValueAt(postion,false);
                            a=1;

                        }
                    }
                });

            }
        };
        lv_test_8.setAdapter(lv_test_8_adapter);
    }
}
