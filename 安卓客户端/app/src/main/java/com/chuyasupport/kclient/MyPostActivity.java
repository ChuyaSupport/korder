package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.Dao.DataTmpDao;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.adapter.MyPostAdapter;
import com.chuyasupport.kclient.entity.response.MyPostResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPostActivity extends AppCompatActivity {
    private android.content.Context context;
    private String TAG = "MyPostActivity";
    private MyPostActivity myPostActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
        context = this;
        myPostActivity = this;

        Call<MyPostResponse> task = NetUtil.getApi().getMyPost(new UserDao(this).select().getUser_id());
        task.enqueue(new Callback<MyPostResponse>() {
            @Override
            public void onResponse(Call<MyPostResponse> call, Response<MyPostResponse> response) {
                RecyclerView recyclerView = findViewById(R.id.my_post_container);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyPostAdapter(myPostActivity, response.body()));
            }

            @Override
            public void onFailure(Call<MyPostResponse> call, Throwable t) {

            }
        });

    }

    public void back(View view) {
        finish();
    }
    public void confirm() {
        Call<String> task = NetUtil.getApi().confirm(new DataTmpDao(this).select());
        task.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response != null && response.body().equals("0")) {
                    Toast.makeText(context, "签收成功", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(context, MyPostActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(context, "签收失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}