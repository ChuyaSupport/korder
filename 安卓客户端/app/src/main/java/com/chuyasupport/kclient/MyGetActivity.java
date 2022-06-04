package com.chuyasupport.kclient;

import android.graphics.Color;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.adapter.MyGetAdapter;
import com.chuyasupport.kclient.entity.response.MyGetResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyGetActivity extends AppCompatActivity {
    private android.content.Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_get);
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
        context = this;

        Call<MyGetResponse> task = NetUtil.getApi().getMyGet(new UserDao(this).select().getUser_id());
        task.enqueue(new Callback<MyGetResponse>() {
            @Override
            public void onResponse(Call<MyGetResponse> call, Response<MyGetResponse> response) {
                RecyclerView recyclerView = findViewById(R.id.my_get_container);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyGetAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<MyGetResponse> call, Throwable t) {

            }
        });




    }
    public void back(View view) {
        finish();
    }
}