package com.chuyasupport.kclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chuyasupport.kclient.R;
import com.chuyasupport.kclient.entity.response.AddressResponse;
import org.jetbrains.annotations.NotNull;

public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.InnerHolder> {
    private AddressResponse addressResponse;
    private String gender;
    public MyAddressAdapter(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }
    @NonNull
    @NotNull
    @Override
    public MyAddressAdapter.InnerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyAddressAdapter.InnerHolder holder, int position) {
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
        public InnerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_address_name);
            gender = itemView.findViewById(R.id.item_address_gender);
            address = itemView.findViewById(R.id.item_address_address);
            phoneNumber = itemView.findViewById(R.id.item_address_phone_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), addressResponse.getAddressList().get(getLayoutPosition()).getAddrId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
