package com.example.administrator.template.TabHostAndViewPager;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.template.TabHostAndViewPager.mainFragment.FirstFragment;
import com.example.administrator.template.R;
import com.example.administrator.template.TabHostAndViewPager.mainFragment.FourthFragment;
import com.example.administrator.template.TabHostAndViewPager.mainFragment.SecondFragment;
import com.example.administrator.template.TabHostAndViewPager.mainFragment.ThirdFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_tab_host)
public class TabHostActivity extends AutoLayoutActivity {

    @ViewById(R.id.fl_content)
    FrameLayout     mFlContent;
    @ViewById(R.id.fth_tab_host)
    FragmentTabHost mFragmentTabHost;

    /**
     * 布局填充器
     */
    private LayoutInflater mInflater;

    /**
     * Fragment数组界面
     */
    private Class  mFragmentArray[] = {FirstFragment.class, SecondFragment.class,
            ThirdFragment.class, FourthFragment.class};
    /**
     * 存放图片数组
     */
    private int    mImageArray[]    = {R.drawable.tab_hot_select, R.drawable.tab_hot_select,
            R.drawable.tab_hot_select, R.drawable.tab_hot_select};
    /**
     * 选项卡文字
     */
    private String mTextArray[]     = {"哈哈", "嘿嘿", "呵呵", "咯咯"};

    private Context context;

    @AfterViews
    void afterViews() {
        context = getBaseContext();

        mInflater = LayoutInflater.from(this);
        // 找到TabHost
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        // 得到fragment的个数
        final int count = mFragmentArray.length;

        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(mTextArray[i]).setIndicator
                    (getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mFragmentTabHost.addTab(tabSpec, mFragmentArray[i], null);

            mFragmentTabHost.getTabWidget().setDividerDrawable(R.color.white);
        }
        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(TabHostActivity.this, "换到了" + tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 给每个Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View      view      = mInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextArray[index]);
        textView.setTextSize(15);
        return view;
    }
}
