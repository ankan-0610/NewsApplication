package com.example.muchnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome,mHealth,mSports,mScience,mEntertainment,mTech,mBusiness;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mHome=findViewById(R.id.home);
        mScience=findViewById(R.id.science);
        mSports=findViewById(R.id.sports);
        mEntertainment=findViewById(R.id.entertainment);
        mTech=findViewById(R.id.tech);
        mHealth=findViewById(R.id.health);
        mBusiness=findViewById(R.id.business);
        ViewPager viewPager=findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()>=0 && tab.getPosition()<=6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }




}