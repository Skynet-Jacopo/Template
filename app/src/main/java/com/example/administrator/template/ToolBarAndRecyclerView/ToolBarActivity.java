package com.example.administrator.template.ToolBarAndRecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.template.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用了RecyclerView,Toobar,CarView
 */
public class ToolBarActivity extends AppCompatActivity implements MyAdapter.OnRecyclerViewListener {

    @Bind(R.id.iv_back)
    ImageView    mIvBack;
    @Bind(R.id.btn_commercial)
    Button       mBtnCommercial;
    @Bind(R.id.btn_group_buying)
    Button       mBtnGroupBuying;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<String> datas = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);
        if (mRecyclerView != null) {
            //在回收时可以提高性能
            mRecyclerView.setHasFixedSize(true);
        }
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        //线性宫格显示 类似于瀑布流
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < 20; i++) {
            datas.add("测试" + i);
        }
        mAdapter = new MyAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnRecyclerViewListener(this);
    }

    @OnClick({R.id.iv_back, R.id.btn_commercial, R.id.btn_group_buying, R.id.recycler_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_commercial:
                Toast.makeText(ToolBarActivity.this, "商户", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_group_buying:
                Toast.makeText(ToolBarActivity.this, "团购", Toast.LENGTH_SHORT).show();
                break;
            case R.id.recycler_view:
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(ToolBarActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        Toast.makeText(ToolBarActivity.this, "长按了" + position, Toast.LENGTH_SHORT).show();
        return false;
    }
}
