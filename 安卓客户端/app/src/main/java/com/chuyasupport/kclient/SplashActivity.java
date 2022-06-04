package com.chuyasupport.kclient;

import android.content.Intent;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.pojo.User;
import com.chuyasupport.kclient.entity.request.LoginRequest;
import com.chuyasupport.kclient.entity.response.LoginResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //隐藏标题栏
        getSupportActionBar().hide();

        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Thread(() -> {
            try {
                sleep(2000);
                if(isLogin()) {
                    Intent intent = new Intent(this, FindActivity.class);
                    startActivity(intent);
                    finish();
//                    dataUpdate(this);
                }
                else {
                    sleep(2000);
                    //跳转主界面
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    //关闭当前活动
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    public Boolean isLogin() {
        UserDao userDao = new UserDao(this);
        User user = userDao.select();
        if(user != null) {
            return true;
        }
        return false;
    }
    public void dataUpdate(android.content.Context context) {
        new Thread(() -> {
            User user = new UserDao(this).select();
            Call<LoginResponse> task = NetUtil.getApi().login(new LoginRequest(user.getPhone_number(), user.getPassword()));
            task.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    new UserDao(context).update(new User(
                            response.body().getUserId(),
                            response.body().getUserName(),
                            response.body().getAvartarUrl(),
                            response.body().getPhoneNumber(),
                            response.body().getBalance().toString(),
                            response.body().getGender(),
                            response.body().getPassword()

                    ));
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
//                    try {
//                        sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    Toast.makeText(context, "连接服务器失败，请检查网络", Toast.LENGTH_SHORT).show();
//                    dataUpdate(context);
                }
            });
        }).start();
    }
}