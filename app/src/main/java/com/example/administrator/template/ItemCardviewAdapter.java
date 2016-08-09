package com.example.administrator.template;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemCardviewAdapter extends BaseAdapter implements View.OnClickListener {

    private List<String> datas = new ArrayList<String>();

    private Context        context;
    private LayoutInflater layoutInflater;

    public ItemCardviewAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_cardview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(datas.get(position));
//        convertView.setFocusable(true);
        convertView.findViewById(R.id.iv_smile_face).setOnClickListener(this);
        convertView.findViewById(R.id.iv_sad_face).setOnClickListener(this);
        convertView.findViewById(R.id.tv_favour).setOnClickListener(this);
        convertView.findViewById(R.id.tv_comment).setOnClickListener(this);
        convertView.findViewById(R.id.iv_comment).setOnClickListener(this);
        convertView.findViewById(R.id.iv_more).setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_favour:
                Toast.makeText(v.getContext(), "赞", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_comment:
                Toast.makeText(v.getContext(), "评论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_smile_face:
                Toast.makeText(v.getContext(), "笑脸", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_sad_face:
                Toast.makeText(v.getContext(), "哭脸", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_comment:
                Toast.makeText(v.getContext(), "评论图片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_more:
                Toast.makeText(v.getContext(), "更多", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected static class ViewHolder {
        private CardView  cardView;
        private ImageView ivIcon;
        private TextView  tvTitle;
        private TextView  tvDes;
        private ImageView ivPic;
        private TextView  tvFavour;
        private TextView  tvComment;
        private ImageView ivSmileFace;
        private ImageView ivSadFace;
        private ImageView ivComment;
        private ImageView ivMore;

        public ViewHolder(View view) {
            cardView = (CardView) view.findViewById(R.id.card_view);
            ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvDes = (TextView) view.findViewById(R.id.tv_des);
            ivPic = (ImageView) view.findViewById(R.id.iv_pic);
            tvFavour = (TextView) view.findViewById(R.id.tv_favour);
            tvComment = (TextView) view.findViewById(R.id.tv_comment);
            ivSmileFace = (ImageView) view.findViewById(R.id.iv_smile_face);
            ivSadFace = (ImageView) view.findViewById(R.id.iv_sad_face);
            ivComment = (ImageView) view.findViewById(R.id.iv_comment);
            ivMore = (ImageView) view.findViewById(R.id.iv_more);
        }
    }
}
