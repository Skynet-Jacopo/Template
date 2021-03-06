package com.example.administrator.template.template8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.template.R;

import java.util.ArrayList;
import java.util.List;

public class ItemUnnormalAdapter extends BaseAdapter {

    private List<String> objects = new ArrayList<String>();

    private Context        context;
    private LayoutInflater layoutInflater;

    public ItemUnnormalAdapter(Context context,List<String> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public String getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_unnormal, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvDiscount.setText(objects.get(position));
        return convertView;
    }


    protected class ViewHolder {
        private ImageView ivPic;
        private TextView  tvStoreName;
        private ImageView ivType1;
        private ImageView ivType2;
        private TextView  tvSupportNumber;
        private TextView  tvDes;
        private ImageView ivType3;
        private TextView  tvDiscount;

        public ViewHolder(View view) {
            ivPic = (ImageView) view.findViewById(R.id.iv_pic);
            tvStoreName = (TextView) view.findViewById(R.id.tv_store_name);
            ivType1 = (ImageView) view.findViewById(R.id.iv_type1);
            ivType2 = (ImageView) view.findViewById(R.id.iv_type2);
            tvSupportNumber = (TextView) view.findViewById(R.id.tv_support_number);
            tvDes = (TextView) view.findViewById(R.id.tv_des);
            ivType3 = (ImageView) view.findViewById(R.id.iv_type3);
            tvDiscount = (TextView) view.findViewById(R.id.tv_discount);
        }
    }
}
