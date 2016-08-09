package com.example.administrator.template.ToolBarAndRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.template.R;

import java.util.List;

/**
 * Created by liuqun on 7/29/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> datas = null;

    public MyAdapter(List<String> datas) {
        this.datas = datas;
    }

    public static interface OnRecyclerViewListener {
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cardview_item, viewGroup,
                false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mName.setText(datas.get(position));
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        public View mRootView;

        public TextView  mName;
        public ImageView mIvPic;
        public TextView  mTvPeopleNum;
        public TextView  mTvDes;
        public TextView  mTvDistance;

        public ViewHolder(View view) {
            super(view);
            mIvPic = (ImageView) view.findViewById(R.id.iv_pic);
            mName = (TextView) view.findViewById(R.id.tv_name);
            mTvPeopleNum = (TextView) view.findViewById(R.id.tv_people_number);
            mTvDes = (TextView) view.findViewById(R.id.tv_des);
            mTvDistance = (TextView) view.findViewById(R.id.tv_distance);

            mRootView = view.findViewById(R.id.item_cardView);
            mRootView.setOnClickListener(this);
            mRootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(this.getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener) {
                return onRecyclerViewListener.onItemLongClick(this.getAdapterPosition());
            }
            return false;
        }
    }
}
