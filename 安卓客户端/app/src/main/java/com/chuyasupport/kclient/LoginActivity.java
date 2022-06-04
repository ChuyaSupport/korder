package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.pojo.User;
import com.chuyasupport.kclient.entity.request.LoginRequest;
import com.chuyasupport.kclient.entity.response.LoginResponse;
import com.chuyasupport.kclient.utils.DBUtil;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText loginPhoneNumber;
    private EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
        loginPhoneNumber = findViewById(R.id.login_phone_number);
        loginPassword = findViewById(R.id.login_password);
        DBUtil dbUtil = new DBUtil(this);
        dbUtil.getWritableDatabase();
    }

    public void onSuccess(LoginResponse loginResponse) {
        if (loginResponse != null && loginResponse.getStatus() != -1) {

            UserDao userDao = new UserDao(this);

            if (userDao.select() == null) {
                userDao.insert(new User(loginResponse.getUserId(), loginResponse.getUserName(), loginResponse.getAvartarUrl(),
                        loginResponse.getPhoneNumber(), loginResponse.getBalance().toString(), loginResponse.getGender(), loginResponse.getPassword()));
            }else {
                userDao.update(new User(loginResponse.getUserId(), loginResponse.getUserName(), loginResponse.getAvartarUrl(),
                        loginResponse.getPhoneNumber(), loginResponse.getBalance().toString(), loginResponse.getGender(), loginResponse.getPassword()));
            }
            User user = userDao.select();

            Log.d(TAG, "onSuccess: " + user);

            Intent intent = new Intent(this, FindActivity.class);
            startActivity(intent);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void onFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
    public void login(View view) {
        Call<LoginResponse> task = NetUtil.getApi().login(new LoginRequest(loginPhoneNumber.getText().toString(), loginPassword.getText().toString()));
        task.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                onFail();
                Log.d(TAG, "onFailure: t = " + t);
            }
        });
    }
}