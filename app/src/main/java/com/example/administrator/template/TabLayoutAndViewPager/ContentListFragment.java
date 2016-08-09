package com.example.administrator.template.TabLayoutAndViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.template.ItemCardviewAdapter;
import com.example.administrator.template.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liuqun on 6/30/2016.
 */
public class ContentListFragment extends Fragment {


    @Bind(R.id.lvRepos)
    ListView mLvRepos;

    private ItemCardviewAdapter mAdapter;
    private List<String> datas = new ArrayList<>();

    public static ContentListFragment getInstance(String title) {
        ContentListFragment fragment = new ContentListFragment();
        Bundle              bundle   = new Bundle();
        bundle.putSerializable("key_language", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 20; i++) {
            datas.add("我是第" + i + "条数据");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        // TODO: 8/8/2016 这里是假数据
//        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout
//                .simple_list_item_1);
//        mLvRepos.setAdapter(mAdapter);
//        mAdapter.addAll(datas);
        mAdapter = new ItemCardviewAdapter(getContext(),datas);
        mAdapter.notifyDataSetChanged();
        mLvRepos.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
