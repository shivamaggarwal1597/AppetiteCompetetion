package com.example.shivam.appetite.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shivam.appetite.BuyGi;
import com.example.shivam.appetite.DescGi;
import com.example.shivam.appetite.R;
import com.example.shivam.appetite.RegisterBuyer;
import com.example.shivam.appetite.models.GiModel;
import com.example.shivam.appetite.models.Seller;
import com.example.shivam.appetite.view_holders.GiViewHolder;
import com.example.shivam.appetite.view_holders.SellerViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */

public class SellerAdapter extends RecyclerView.Adapter<SellerViewHolder> {
    public List<Seller> sellerModels;
    public Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    public SellerAdapter(Context context, List<Seller> models){

        this.sellerModels = models;
        this.context = context;
    }

    @Override
    public SellerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SellerViewHolder sellerViewHolder = null;
        LayoutInflater li= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = li.inflate(R.layout.custom_seller_layout,parent,false);
        sellerViewHolder = new SellerViewHolder(layoutView, sellerModels);
        //firebaseStorage = FirebaseStorage.getInstance();
        //firebaseDatabase = FirebaseDatabase.getInstance();
        // databaseReference = firebaseDatabase.getReference();
        //  storageReference = firebaseStorage.getReferenceFromUrl("gs://whereismybholastaff.appspot.com/");
        return sellerViewHolder;
    }

    @Override
    public void onBindViewHolder(SellerViewHolder holder, final int position) {
        holder.name_of_seller_text_view.setText(sellerModels.get(position).getSeller_name());
        holder.price_of_seller_text_view.setText(sellerModels.get(position).getSeller_price());
        holder.rating_of_seller_text_view.setText(sellerModels.get(position).getRating().toString());
        holder.address_of_seller_text_view.setText(sellerModels.get(position).getAddress().toString());
        holder.seller_choose_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,BuyGi.class);
               String seller_no = sellerModels.get(position).getSeller_contact_no();
                String seller_address = sellerModels.get(position).getAddress();
                String seller_pri = sellerModels.get(position).getSeller_price();

                intent.putExtra("seller_price",seller_pri);

                intent.putExtra("seller_address",seller_address);

                intent.putExtra("seller_no",seller_no);
                Toast.makeText(context,seller_no,Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {

        return sellerModels.size();
    }
}