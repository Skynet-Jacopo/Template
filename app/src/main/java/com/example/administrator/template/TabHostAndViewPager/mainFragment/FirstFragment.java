package com.example.administrator.template.TabHostAndViewPager.mainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.template.R;
import com.example.administrator.template.TabHostAndViewPager.Content1Fragment;

public class FirstFragment extends Fragment  {

    private FrameLayout      container;
    private Content1Fragment mContentFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = (FrameLayout) view.findViewById(R.id.container);
        mContentFragment = new Content1Fragment();
        FragmentManager     fragmentManager =getActivity().getSupportFragmentManager();
        FragmentTransaction transaction     =fragmentManager.beginTransaction();
        transaction.replace(R.id.container, mContentFragment);
        transaction.commit();
    }

}
