package com.example.shivam.appetite.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shivam.appetite.R;
import com.example.shivam.appetite.models.GiModel;
import com.example.shivam.appetite.models.Seller;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */

public class SellerViewHolder extends RecyclerView.ViewHolder{
    public Button seller_choose_button;
    public TextView name_of_seller_text_view,address_of_seller_text_view,rating_of_seller_text_view,
            price_of_seller_text_view;
    public List<Seller> taskObj;
    public SellerViewHolder(final View itemView, List<Seller> sellerModels) {
        super(itemView);
        this.taskObj = sellerModels;
        seller_choose_button = (Button)itemView.findViewById(R.id.choose_seller_button_custom);
        name_of_seller_text_view = (TextView) itemView.findViewById(R.id.name_text_view_custom_seller);
        address_of_seller_text_view = (TextView)itemView.findViewById(R.id.address_of_seller_custom_seller_text_view);
        rating_of_seller_text_view = (TextView)itemView.findViewById(R.id.rating_text_view_custom_seller);
        price_of_seller_text_view = (TextView)itemView.findViewById(R.id.price_text_view_custom_seller);

         }
}
