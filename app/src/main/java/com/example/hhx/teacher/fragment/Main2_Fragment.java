package com.example.hhx.teacher.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 哈哈嘻 on 2016/11/12.
 */

public class Main2_Fragment extends Fragment {
    private String mTitle;
    public static final String BUNDLE_TITLE="title";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       Bundle bundle=getArguments();
        Log.i("hhx", String.valueOf(bundle));
        if(bundle!=null){
            mTitle=bundle.getString(BUNDLE_TITLE);
        }

        TextView tv=new TextView(getActivity());
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static Main2_Fragment newInstance(String title){
        Log.i("hhx","diao");
        Bundle bundle=new Bundle();
        bundle.putString(BUNDLE_TITLE,title);
        Main2_Fragment fragement = new Main2_Fragment();
        fragement.setArguments(bundle);
        return fragement;
    }

}
