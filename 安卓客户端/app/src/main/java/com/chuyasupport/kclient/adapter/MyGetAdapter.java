package com.chuyasupport.kclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.R;
import com.chuyasupport.kclient.entity.response.MyGetResponse;
import org.jetbrains.annotations.NotNull;

public class MyGetAdapter extends RecyclerView.Adapter<MyGetAdapter.InnerHolder> {
    private MyGetResponse myGetResponse;
    private int status;
    public MyGetAdapter(MyGetResponse myGetResponse) {
        this.myGetResponse = myGetResponse;
    }
    @NonNull
    @NotNull
    @Override
    public MyGetAdapter.InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_get, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyGetAdapter.InnerHolder holder, int position) {
        holder.get_package_code.setText(myGetResponse.getVmyGetList().get(position).getPackageCode());
        holder.get_get_addr.setText(myGetResponse.getVmyGetList().get(position).getGetAddr());
        holder.get_to_addr.setText(myGetResponse.getVmyGetList().get(position).getAddress());
        holder.get_reward.setText(myGetResponse.getVmyGetList().get(position).getReward());
        holder.get_to_name.setText(myGetResponse.getVmyGetList().get(position).getUserName());
        holder.get_to_phone_number.setText(myGetResponse.getVmyGetList().get(position).getPhoneNumber());
        holder.get_package_size.setText(myGetResponse.getVmyGetList().get(position).getPackageSize());
        status = myGetResponse.getVmyGetList().get(position).getStatus();
        if(status == 1) {
            holder.get_status.setText("待完成");
        }
        if(status == 2) {
            holder.get_status.setText("已完成");
        }
    }

    @Override
    public int getItemCount() {
        return myGetResponse.getVmyGetList().size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView get_get_addr;
        private TextView get_package_code;
        private TextView get_to_addr;
        private TextView get_to_name;
        private TextView get_to_phone_number;
        private TextView get_package_size;
        private TextView get_reward;
        private Button get_status;
        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            get_get_addr = itemView.findViewById(R.id.get_get_addr);
            get_package_code = itemView.findViewById(R.id.get_package_code);
            get_to_addr = itemView.findViewById(R.id.get_to_addr);
            get_to_name = itemView.findViewById(R.id.get_to_name);
            get_to_phone_number = itemView.findViewById(R.id.get_to_phone_number);
            get_package_size = itemView.findViewById(R.id.get_package_size);
            get_reward = itemView.findViewById(R.id.get_reward);
            get_status = itemView.findViewById(R.id.get_status);
        }
    }
}
