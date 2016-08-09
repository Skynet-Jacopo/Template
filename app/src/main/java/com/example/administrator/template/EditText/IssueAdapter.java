package com.example.administrator.template.EditText;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.R;

import java.util.List;

/**
 * Created by liuqun on 8/1/2016.
 */
public class IssueAdapter extends BaseAdapter {
    private Context        context;
    private LayoutInflater mInflater;
    private List<String> datas = null;
    public IssueAdapter(List<String> datas, Context context) {
        this.context = context;
        this.datas =datas;
        mInflater =LayoutInflater.from(context);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_issue,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTvIssueName.setText(datas.get(position));
        convertView.findViewById(R.id.llayout_support).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "顶一个", Toast.LENGTH_SHORT).show();
            }
        });
        convertView.findViewById(R.id.tv_reply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "回复一个", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    static class ViewHolder{

        private final TextView mTvIssueName;
        private final TextView mTvIssueContent;
        private final TextView mTvSupport;
        private final TextView mTvSupportNumber;
        private final TextView mTvReply;
        private final LinearLayout mLlayoutSupport;

        public ViewHolder(View view) {
            mTvIssueName = (TextView) view.findViewById(R.id.tv_issue_name);
            mTvIssueContent = (TextView) view.findViewById(R.id.tv_issue_content);
            mLlayoutSupport = (LinearLayout) view.findViewById(R.id.llayout_support);
            mTvSupport = (TextView) view.findViewById(R.id.tv_support);
            mTvSupportNumber = (TextView) view.findViewById(R.id.tv_support_number);
            mTvReply = (TextView) view.findViewById(R.id.tv_reply);
        }
    }
}
