package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.adapter.MyAddressAdapter;
import com.chuyasupport.kclient.entity.response.AddressResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAddressActivity extends AppCompatActivity {
    private static final String TAG = "MyAddressActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
        getData(this, new UserDao(this).select().getUser_id());

    }
    public void back(View view) {
        finish();
    }
    public void newAddress(View view) {
        Intent intent = new Intent(this, AddAddressActivity.class);
        startActivity(intent);
    }

    public void getData(android.content.Context context, String userId) {
        Call<AddressResponse> task = NetUtil.getApi().getAddress(userId);
        task.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                if(response.body() != null) {
                    //设置RecyclerView
                    RecyclerView recyclerView = findViewById(R.id.my_address_container);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new MyAddressAdapter(response.body()));

                }else {
                    Toast.makeText(context, "网络异常", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t);
            }
        });
    }
}