package com.example.administrator.template.GridView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.example.administrator.template.abslistview.CommonAdapter;
import com.example.administrator.template.basesadapter.ViewHolder;
import com.example.administrator.template.fixed.FixedGridView;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.utils.AutoUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_grid_view)
public class GridViewActivity extends AutoLayoutActivity {
    @ViewById
    FixedGridView gv_list;

    @ViewById
    FixedGridView gv_more_list;
    List<String> gridViewData = new ArrayList<>();

    CommonAdapter gridViewAdapter;

    @AfterViews
    void afterViews() {
        initData();
    }

    private void initData() {
        for (int i = 0; i < 18; i++) {
            gridViewData.add(i + "");
        }
        gridViewAdapter = new CommonAdapter<String>(getApplicationContext(), R.layout.item_shape, gridViewData) {

            @Override
            protected void onConvertViewCreated(View convertView) {
                AutoUtils.autoSize(convertView);
            }

            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_item, s);
            }
        };
        gv_list.setAdapter(gridViewAdapter);
        gv_more_list.setAdapter(gridViewAdapter);
        gv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "点击了"+position, 0).show();
            }
        });
        gv_more_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "点击了"+position, 0).show();
            }
        });
    }
}
