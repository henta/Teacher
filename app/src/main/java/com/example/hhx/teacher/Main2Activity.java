package com.example.hhx.teacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.hhx.teacher.fragment.Main2_Fragment;
import com.example.hhx.teacher.view.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;
    private List<String> mTitles = Arrays.asList("用户","课程","二维码");
    private List<Main2_Fragment> mContents = new ArrayList<Main2_Fragment>();
    private FragmentPagerAdapter mAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        initViews();

        initDatas();

        mViewPager.setAdapter(mAdpter);
    }

    private void initDatas() {
        for(String title:mTitles){
            Main2_Fragment fragment =Main2_Fragment.newInstance(title);
            mContents.add(fragment);
        }
        mAdpter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
    }


}
