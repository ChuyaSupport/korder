package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.request.AddAddressRequest;
import com.chuyasupport.kclient.entity.response.AddAddressResponse;
import com.chuyasupport.kclient.entity.response.AddressResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAddressActivity extends AppCompatActivity {

    private TextView add_address_name;
    private TextView add_address_gender;
    private TextView add_address_address;
    private TextView add_address_phone_number;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));

        add_address_name = findViewById(R.id.add_address_name);
        add_address_gender = findViewById(R.id.add_address_gender);
        add_address_address = findViewById(R.id.add_address_address);
        add_address_phone_number = findViewById(R.id.add_address_phone_number);
        intent = new Intent(this, MyAddressActivity.class);

    }
    public void back(View view) {
        finish();
    }
    public void addAddress(View view) {
        Call<AddAddressResponse> task = NetUtil.getApi().addAddress(new AddAddressRequest(
                add_address_name.getText().toString(),
                add_address_gender.getText().toString(),
                add_address_address.getText().toString(),
                add_address_phone_number.getText().toString(),
                new UserDao(this).select().getUser_id()
        ));
        task.enqueue(new Callback<AddAddressResponse>() {
            @Override
            public void onResponse(Call<AddAddressResponse> call, Response<AddAddressResponse> response) {
                if (response != null &&response.body().getStatus().equals("0")) {
                    Toast.makeText(AddAddressActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    getParent().finish();
                    getParent().finish();
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<AddAddressResponse> call, Throwable t) {
                Toast.makeText(AddAddressActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}