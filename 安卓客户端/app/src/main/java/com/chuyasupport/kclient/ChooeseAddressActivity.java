package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.adapter.ChooseAddressViewAdapter;
import com.chuyasupport.kclient.entity.response.AddressResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooeseAddressActivity extends AppCompatActivity {
    private static final String TAG = "ChooeseAddressActivity";
    private ChooeseAddressActivity chooeseAddressActivity;
    private android.content.Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooese_address);
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
         chooeseAddressActivity = this;
         context = this;
         intent = new Intent(this, AddAddressActivity.class);


        Call<AddressResponse> task = NetUtil.getApi().getAddress(new UserDao(this).select().getUser_id());
        task.enqueue(new Callback<AddressResponse>() {
            @Override
            public void onResponse(Call<AddressResponse> call, Response<AddressResponse> response) {
                RecyclerView recyclerView = findViewById(R.id.choose_address_container);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new ChooseAddressViewAdapter(chooeseAddressActivity, response.body(), PostActivity.postActivity));
            }

            @Override
            public void onFailure(Call<AddressResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }

    public void back(View view) {
        finish();
    }
    public void addAddress(View view) {
        startActivity(intent);
    }
}