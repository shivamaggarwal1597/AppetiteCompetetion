package com.example.shivam.appetite.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shivam.appetite.R;
import com.example.shivam.appetite.models.GiModel;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */

public class GiViewHolder extends RecyclerView.ViewHolder {
    public ImageView gi_image_view;
    public Button gi_btn;
    public TextView category_of_gi_text_view,name_of_gi_text_view,price_of_gi_text_view,
            state_of_gi_text_view;
    public List<GiModel> taskObj;
    public GiViewHolder(final View itemView, List<GiModel> giModels) {
        super(itemView);
        this.taskObj = giModels;
        category_of_gi_text_view = (TextView)itemView.findViewById(R.id.category_gi_custom_text_view);
        name_of_gi_text_view = (TextView)itemView.findViewById(R.id.name_gi_custom_text_view);
        state_of_gi_text_view = (TextView)itemView.findViewById(R.id.state_gi_custom_text_view);
        gi_image_view = (ImageView)itemView.findViewById(R.id.image_gi_custom_image_view);
        gi_btn=(Button)itemView.findViewById(R.id.navigate_gi_custom_button);
    }
}