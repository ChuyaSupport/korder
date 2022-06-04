package com.chuyasupport.kclient.adapter;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.ChooeseAddressActivity;
import com.chuyasupport.kclient.Dao.DataTmpDao;
import com.chuyasupport.kclient.PostActivity;
import com.chuyasupport.kclient.R;
import com.chuyasupport.kclient.entity.response.AddressResponse;
import org.jetbrains.annotations.NotNull;

public class ChooseAddressViewAdapter extends RecyclerView.Adapter<ChooseAddressViewAdapter.InnerHolder> {
    private AddressResponse addressResponse;
    private String gender;
    private ViewGroup viewGroup;
    private ChooeseAddressActivity chooeseAddressActivity;
    private PostActivity postActivity;
    public ChooseAddressViewAdapter(ChooeseAddressActivity chooeseAddressActivity, AddressResponse addressResponse, PostActivity postActivity) {
        this.chooeseAddressActivity = chooeseAddressActivity;
        this.addressResponse = addressResponse;
        this.postActivity = postActivity;
    }
    @NonNull
    @NotNull
    @Override
    public ChooseAddressViewAdapter.InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
         viewGroup= parent;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChooseAddressViewAdapter.InnerHolder holder, int position) {
        holder.name.setText(addressResponse.getAddressList().get(position).getUserName());
        gender = addressResponse.getAddressList().get(position).getGender();

        if(gender.equals("男")) {
            holder.gender.setText("先生");
        }
        if (gender.equals("女")) {
            holder.gender.setText("女士");
        }


        holder.address.setText(addressResponse.getAddressList().get(position).getAddress());
        holder.phoneNumber.setText(addressResponse.getAddressList().get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return addressResponse.getAddressList().size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView gender;
        TextView address;
        TextView phoneNumber;
        TextView post_addr_id;
        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_address_name);
            gender = itemView.findViewById(R.id.item_address_gender);
            address = itemView.findViewById(R.id.item_address_address);
            phoneNumber = itemView.findViewById(R.id.item_address_phone_number);
            post_addr_id = postActivity.findViewById(R.id.post_addr_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DataTmpDao(itemView.getContext()).update(addressResponse.getAddressList().get(getLayoutPosition()).getAddrId());
                    post_addr_id.setGravity(Gravity.LEFT);
                    post_addr_id.setTextColor(Color.rgb(0x00, 0x00, 0x00));
                    post_addr_id.setText(
                            addressResponse.getAddressList().get(getLayoutPosition()).getUserName() + "," +
                                    addressResponse.getAddressList().get(getLayoutPosition()).getPhoneNumber() + "," +
                                    addressResponse.getAddressList().get(getLayoutPosition()).getAddress());
                    chooeseAddressActivity.back(itemView);
                    chooeseAddressActivity.finish();
                }
            });
        }
    }
}
