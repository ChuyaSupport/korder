package com.chuyasupport.kclient;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.pojo.User;
import com.chuyasupport.kclient.utils.Constants;
import com.chuyasupport.kclient.utils.DBUtil;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class MyActivity extends AppCompatActivity {
    private ImageView myAvartar;
    private TextView myUserName;
    private TextView myUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent findIntent = new Intent(this, FindActivity.class);
        Intent postIntent = new Intent(this, PostActivity.class);
        Intent messageIntent = new Intent(this, MessageActivity.class);
        Intent myIntent = new Intent(this, MyActivity.class);
        myAvartar = findViewById(R.id.my_avartar);
        myUserName = findViewById(R.id.my_user_name);
        myUserId = findViewById(R.id.my_user_id);

        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xff, 0x6b, 0x00));

        UserDao userDao = new UserDao(this);

        User user = userDao.select();
        Picasso.with(this).load(user.getAvartar_url()).into(myAvartar);
        myUserName.setText(user.getUser_name());
        myUserId.setText(user.getUser_id());

        TabLayout tabLayout = findViewById(R.id.tab_layout_my);
        tabLayout.getTabAt(3).select();
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
    public void myAddress(View view) {
        Intent intent = new Intent(this, MyAddressActivity.class);
        startActivity(intent);
    }
    public void gotoMyGet(View view) {
        Intent intent = new Intent(this, MyGetActivity.class);
        startActivity(intent);
    }
    public void gotoMyPost(View view) {
        Intent intent = new Intent(this, MyPostActivity.class);
        startActivity(intent);
    }
    public void logoff(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}