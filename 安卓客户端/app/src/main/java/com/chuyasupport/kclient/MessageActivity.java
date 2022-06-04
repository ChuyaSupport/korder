package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent findIntent = new Intent(this, FindActivity.class);
        Intent postIntent = new Intent(this, PostActivity.class);
        Intent messageIntent = new Intent(this, MessageActivity.class);
        Intent myIntent = new Intent(this, MyActivity.class);

        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));

        TabLayout tabLayout = findViewById(R.id.tab_layout_message);
        tabLayout.getTabAt(2).select();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    startActivity(findIntent);
                    finish();
                }
                if(tab.getPosition() == 1) {
                    startActivity(postIntent);
                    finish();
                }
                if(tab.getPosition() == 2) {
                    startActivity(messageIntent);
                    finish();
                }
                if(tab.getPosition() == 3) {
                    startActivity(myIntent);
                    finish();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}