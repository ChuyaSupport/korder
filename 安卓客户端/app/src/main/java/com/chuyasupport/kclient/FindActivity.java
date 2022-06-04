package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.adapter.FindViewAdapter;
import com.chuyasupport.kclient.entity.response.FindResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import com.google.android.material.tabs.TabLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindActivity extends AppCompatActivity {

    private static final String TAG = "FindActivity";
    private android.content.Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Intent findIntent = new Intent(this, FindActivity.class);
        Intent postIntent = new Intent(this, PostActivity.class);
        Intent messageIntent = new Intent(this, MessageActivity.class);
        Intent myIntent = new Intent(this, MyActivity.class);
        context = this;
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));

        Call<FindResponse> task = NetUtil.getApi().getFindData();
        task.enqueue(new Callback<FindResponse>() {
            @Override
            public void onResponse(Call<FindResponse> call, Response<FindResponse> response) {
                if(response != null && response.body().getStatus() != -1) {
                    //设置RecyclerView
                    RecyclerView recyclerView = findViewById(R.id.find_container);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getParent()));
                    recyclerView.setAdapter(new FindViewAdapter(context, response.body().getVfindResponseList()));
                }
            }

            @Override
            public void onFailure(Call<FindResponse> call, Throwable t) {
                Log.d(TAG, "onResponse:" + t);
            }
        });


        TabLayout tabLayout = findViewById(R.id.tab_layout_find);
        tabLayout.getTabAt(0).select();
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