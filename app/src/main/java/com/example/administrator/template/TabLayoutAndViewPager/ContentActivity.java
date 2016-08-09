package com.example.administrator.template.TabLayoutAndViewPager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.template.R;

import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity {

    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_content_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);

        mContentFragment = new ContentFragment();
        FragmentManager     fragmentManager =getSupportFragmentManager();
        FragmentTransaction transaction     =fragmentManager.beginTransaction();
        transaction.replace(R.id.container, mContentFragment);
        transaction.commit();
    }
}