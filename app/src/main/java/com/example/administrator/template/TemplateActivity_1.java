package com.example.administrator.template;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateActivity_1 extends AppCompatActivity {

    ExpandableListView mainlistview = null;
    List<String> parent = null;
    Map<String, List<String>> map = null;
    GridView gv_test_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        mainlistview = (ExpandableListView) this
                .findViewById(R.id.main_expandablelistview);

        gv_test_1=(GridView)findViewById(R.id.gv_test_1);

        //配置适配器
        gv_test_1.setAdapter(new GridViewAdapter(this));
        initData();
        mainlistview.setAdapter(new MyAdapter());
    }

    //自定义适配器
    class GridViewAdapter extends BaseAdapter {
        //上下文对象
        private Context context;
        //图片数组
        private String[] imgs = {
                "电视机","电视机啊电视机","电视机啊飒飒大","电视机的防守打法","电视机","电视机方法","电视机发","电视机阿达","电视机撒的","电视机阿斯顿",
        };

        GridViewAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return imgs.length;
        }

        public Object getItem(int item) {
            return item;
        }

        public long getItemId(int id) {
            return id;
        }

        //创建View方法
        public View getView(int position, View convertView, ViewGroup parent) {
          TextView textView;
            if (convertView == null) {
                textView=new TextView(context);


            } else {
                textView = (TextView) convertView;
            }
            textView.setText(imgs[position]);//为ImageView设置图片资源
            return textView;
        }

    }

        // 初始化数据
    public void initData() {
        parent = new ArrayList<String>();
        parent.add("测试1");
        parent.add("测试2");
        parent.add("测试3");
        parent.add("测试4");
        parent.add("测试5");

        map = new HashMap<String, List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("child1-1");
        list1.add("child1-2");
        list1.add("child1-3");
        map.put("测试1", list1);

        List<String> list2 = new ArrayList<String>();
        list2.add("child2-1");
        list2.add("child2-2");
        list2.add("child2-3");
        map.put("测试2", list2);

        List<String> list3 = new ArrayList<String>();
        list3.add("child3-1");
        list3.add("child3-2");
        list3.add("child3-3");
        map.put("测试3", list3);

        List<String> list4 = new ArrayList<String>();
        list4.add("child3-1");
        list4.add("child3-2");
        list4.add("child3-3");
        map.put("测试4", list4);

        List<String> list5 = new ArrayList<String>();
        list5.add("child3-1");
        list5.add("child3-2");
        list5.add("child3-3");
        map.put("测试5", list5);


        mainlistview.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = mainlistview.getExpandableListAdapter().getGroupCount();
                for(int j = 0; j < count; j++){
                    if(j != groupPosition){
                        mainlistview.collapseGroup(j);
                    }
                }
            }
        });
    }

    class MyAdapter extends BaseExpandableListAdapter {

        //得到子item需要关联的数据
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            String key = parent.get(groupPosition);
            return (map.get(key).get(childPosition));
        }

        //得到子item的ID
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //设置子item的组件
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            String key = TemplateActivity_1.this.parent.get(groupPosition);
            String info = map.get(key).get(childPosition);
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) TemplateActivity_1.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_test_1_children, null);
            }
            TextView tv = (TextView) convertView
                    .findViewById(R.id.second_textview);
            tv.setText(info);
            return tv;
        }

        //获取当前父item下的子item的个数
        @Override
        public int getChildrenCount(int groupPosition) {
            String key = parent.get(groupPosition);
            int size=map.get(key).size();
            return size;
        }
        //获取当前父item的数据
        @Override
        public Object getGroup(int groupPosition) {
            return parent.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return parent.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }
        //设置父item组件
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) TemplateActivity_1.this
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_test_1_parent, null);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.parent_textview);
            tv.setText(TemplateActivity_1.this.parent.get(groupPosition));

            ImageView parent_img=(ImageView)convertView.findViewById(R.id.parent_img);
            if (isExpanded){
                parent_img.setBackgroundResource(R.drawable.arrow_down);
            }else {
                parent_img.setBackgroundResource(R.drawable.back);
            }

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }


}
