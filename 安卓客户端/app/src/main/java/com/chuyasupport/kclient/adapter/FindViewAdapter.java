package com.chuyasupport.kclient.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.FindDetailActivity;
import com.chuyasupport.kclient.R;
import com.chuyasupport.kclient.entity.response.FindResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FindViewAdapter extends RecyclerView.Adapter<FindViewAdapter.InnerHolder> {
    private List<FindResponse.VfindResponseListDTO> vfindResponseListDTOList;
    private Context context;
    public FindViewAdapter(Context context, List<FindResponse.VfindResponseListDTO> vfindResponseListDTOList) {
        this.context = context;
        this.vfindResponseListDTOList = vfindResponseListDTOList;
    }
    @NonNull
    @NotNull
    @Override
    public FindViewAdapter.InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find, parent, false);
        InnerHolder innerHolder = new InnerHolder(view);
        return innerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FindViewAdapter.InnerHolder holder, int position) {
        holder.itemFindTitle.setText(vfindResponseListDTOList.get(position).getGetAddr());
        holder.itemFindSize.setText(vfindResponseListDTOList.get(position).getPackageSize());
        holder.itemFindAddress.setText(vfindResponseListDTOList.get(position).getAddress());
        holder.itemFindReward.setText(vfindResponseListDTOList.get(position).getReward());
    }

    @Override
    public int getItemCount() {
        return vfindResponseListDTOList.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        TextView itemFindTitle;
        TextView itemFindSize;
        TextView itemFindAddress;
        TextView itemFindReward;

        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemFindTitle = itemView.findViewById(R.id.item_find_title);
            itemFindSize = itemView.findViewById(R.id.item_find_size);
            itemFindAddress = itemView.findViewById(R.id.item_find_address);
            itemFindReward = itemView.findViewById(R.id.item_find_reward);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, FindDetailActivity.class);
                    intent.putExtra("postId", vfindResponseListDTOList.get(getLayoutPosition()).getPostId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
