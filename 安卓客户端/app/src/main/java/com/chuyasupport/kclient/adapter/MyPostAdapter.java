package com.chuyasupport.kclient.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.Dao.DataTmpDao;
import com.chuyasupport.kclient.MyPostActivity;
import com.chuyasupport.kclient.R;
import com.chuyasupport.kclient.entity.response.MyPostResponse;
import org.jetbrains.annotations.NotNull;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.InnerHolder> {

    private static final String TAG = "MyPostAdapter";
    private MyPostResponse myPostResponse;
    private MyPostActivity myPostActivity;
    private String tmp;
    public MyPostAdapter(MyPostActivity myPostActivity, MyPostResponse myPostResponse) {
        this.myPostActivity = myPostActivity;
        this.myPostResponse = myPostResponse;
    }

    @NonNull
    @NotNull
    @Override
    public MyPostAdapter.InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_post, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyPostAdapter.InnerHolder holder, int position) {
        holder.post_get_addr.setText(myPostResponse.getVmyPostList().get(position).getGetAddr());
        tmp = myPostResponse.getVmyPostList().get(position).getStatus();
        if(tmp.equals("0"))
            holder.post_status.setText("等待中");
        if(tmp.equals("1"))
            holder.post_status.setText("已接单");
        if(tmp.equals("2"))
            holder.post_status.setText("已签收");
        holder.post_package_code.setText(myPostResponse.getVmyPostList().get(position).getPackageCode());
        holder.post_to_addr.setText(myPostResponse.getVmyPostList().get(position).getAddress());
        holder.post_to_name.setText(myPostResponse.getVmyPostList().get(position).getUserName());
        holder.post_to_phone_number.setText(myPostResponse.getVmyPostList().get(position).getPhoneNumber());
        holder.post_package_size.setText(myPostResponse.getVmyPostList().get(position).getPackageSize());
        holder.post_reward.setText(myPostResponse.getVmyPostList().get(position).getReward());
    }

    @Override
    public int getItemCount() {
        return myPostResponse.getVmyPostList().size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView post_get_addr;
        private Button post_status;
        private TextView post_package_code;
        private TextView post_to_addr;
        private TextView post_to_name;
        private TextView post_to_phone_number;
        private TextView post_package_size;
        private TextView post_reward;
        private TextView btnConfirm;

        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            post_get_addr = itemView.findViewById(R.id.post_get_addr);
            post_status = itemView.findViewById(R.id.post_status);
            post_package_code = itemView.findViewById(R.id.post_package_code);
            post_to_addr = itemView.findViewById(R.id.post_to_addr);
            post_to_name = itemView.findViewById(R.id.post_to_name);
            post_to_phone_number = itemView.findViewById(R.id.post_to_phone_number);
            post_package_size = itemView.findViewById(R.id.post_package_size);
            post_reward = itemView.findViewById(R.id.post_reward);
            btnConfirm = itemView.findViewById(R.id.btn_confirm);
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DataTmpDao(itemView.getContext()).update(myPostResponse.getVmyPostList().get(getLayoutPosition()).getPostId());
                    myPostActivity.confirm();
                }
            });
        }
    }
}
