package com.example.administrator.template.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fixed.FixedListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EFragment(R.layout.fragment_test_3)
public class Fragment_3 extends Fragment {
    private Context context;


    @ViewById
    FixedListView lv_test_3;


    CommonAdapter lv_test_3_adapter;

    String[] test = {"测试1", "测试2", "测试3"};
    List<String> lv_view = new ArrayList<>();


    @AfterViews
    void afterViews() {
        context = getContext();
        lv_view.clear();
        lv_view.addAll(Arrays.asList(test));

        lv_test_3_adapter = new CommonAdapter<String>(context, R.layout.item_test_3_listview, lv_view) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setText(R.id.tv_item_3, str);

            }
        };
        lv_test_3.setAdapter(lv_test_3_adapter);
        lv_test_3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,test[position]+"",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
