package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserView;
import com.chuyasupport.kclient.Dao.DataTmpDao;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.request.PostRequest;
import com.chuyasupport.kclient.entity.response.PostResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import com.google.android.material.tabs.TabLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";
    private EditText post_package_size;
    private EditText post_package_code;
    private EditText post_get_addr;
    private TextView post_addr_id;
    private TextView post_reward;
    private Intent intent;
    private android.content.Context context;
    public static PostActivity postActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent findIntent = new Intent(this, FindActivity.class);
        Intent postIntent = new Intent(this, PostActivity.class);
        Intent messageIntent = new Intent(this, MessageActivity.class);
        Intent myIntent = new Intent(this, MyActivity.class);
        intent  = new Intent(this, FindActivity.class);
        post_package_size = findViewById(R.id.post_package_size);
        post_package_code = findViewById(R.id.post_package_code);
        post_get_addr = findViewById(R.id.post_get_addr);
        post_addr_id = findViewById(R.id.post_addr_id);
        post_reward = findViewById(R.id.post_reward);
        context = this;
        postActivity = this;

        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));

        TabLayout tabLayout = findViewById(R.id.tab_layout_post);
        tabLayout.getTabAt(1).select();
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
    public void post(View view) {
        String userId = new UserDao(this).select().getUser_id();
        String packageCode = post_package_code.getText().toString();
        String getAddr = post_get_addr.getText().toString();
        String addrId = new DataTmpDao(this).select();
        String packageSize = post_package_size.getText().toString();
        String reward = post_reward.getText().toString();
        PostRequest postRequest = new PostRequest(userId, packageCode, getAddr, addrId, packageSize, reward);
        Call<PostResponse> task = NetUtil.getApi().post(postRequest);
        task.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response != null && response.body().getStatus().equals("0")) {
                    Toast.makeText(context, "发布成功", Toast.LENGTH_SHORT).show();
                    finish();
                    finish();
                    startActivity(intent);
                }else {
                    Toast.makeText(context, "发布失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }
    public void chooseAddress(View view) {
        Intent chooseAddressIntent = new Intent(this, ChooeseAddressActivity.class);
        startActivity(chooseAddressIntent);
    }
}