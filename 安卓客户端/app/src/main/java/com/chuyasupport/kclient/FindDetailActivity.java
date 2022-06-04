package com.chuyasupport.kclient;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.chuyasupport.kclient.Dao.UserDao;
import com.chuyasupport.kclient.entity.response.FindDetail;
import com.chuyasupport.kclient.entity.response.GetReceiveResponse;
import com.chuyasupport.kclient.utils.NetUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindDetailActivity extends AppCompatActivity {
    private static final String TAG = "FindDetailActivity";
    private String postId;
    private TextView detail_title;
    private TextView detail_reward;
    private Button detail_size;
    private TextView detail_get_address;
    private TextView detail_get_code;
    private TextView detail_to_address;
    private TextView detail_to_name;
    private TextView detail_to_gender;
    private TextView detail_to_phone_number;
    private String tmp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail);
        //隐藏标题栏
        getSupportActionBar().hide();
        //设置状态栏颜色
        getWindow().setStatusBarColor(Color.rgb(0xa4, 0xa4, 0xa4));
        intent = new Intent(this, FindActivity.class);

        Intent intent = getIntent();
        postId = intent.getStringExtra("postId");

        detail_title = findViewById(R.id.detail_title);
        detail_reward = findViewById(R.id.detail_reward);
        detail_size = findViewById(R.id.detail_size);
        detail_get_address = findViewById(R.id.detail_get_address);
        detail_get_code = findViewById(R.id.detail_get_code);
        detail_to_address = findViewById(R.id.detail_to_address);
        detail_to_name = findViewById(R.id.detail_to_name);
        detail_to_gender = findViewById(R.id.detail_to_gender);
        detail_to_phone_number = findViewById(R.id.detail_to_phone_number);



        Call<FindDetail> task = NetUtil.getApi().getFindDetail(postId);
        task.enqueue(new Callback<FindDetail>() {
            @Override
            public void onResponse(Call<FindDetail> call, Response<FindDetail> response) {
                detail_title.setText(response.body().getGetAddr());
                detail_reward.setText(response.body().getReward());
                detail_size.setText(response.body().getPackageSize());
                detail_get_address.setText(response.body().getGetAddr());
                detail_get_code.setText(response.body().getPackageCode());
                detail_to_address.setText(response.body().getAddress());
                detail_to_name.setText(response.body().getUserName());
                tmp = response.body().getGender();
                if(tmp.equals("男")) {
                    detail_to_gender.setText("(先生)");
                }
                if(tmp.equals("女")) {
                    detail_to_gender.setText("(女士)");
                }
                detail_to_phone_number.setText(response.body().getPhoneNumber());

            }

            @Override
            public void onFailure(Call<FindDetail> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t);
            }
        });
    }
    public void getOrder(View view) {
        Call<GetReceiveResponse> task = NetUtil.getApi().getReceive(new UserDao(this).select().getUser_id(), postId);
        task.enqueue(new Callback<GetReceiveResponse>() {
            @Override
            public void onResponse(Call<GetReceiveResponse> call, Response<GetReceiveResponse> response) {
                if(response != null && response.body().getStatus().equals("0")) {
                    finish();
                    finish();
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<GetReceiveResponse> call, Throwable t) {

            }
        });
    }
}