package com.example.shivam.appetite.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shivam.appetite.BuyGi;
import com.example.shivam.appetite.DescGi;
import com.example.shivam.appetite.R;
import com.example.shivam.appetite.models.GiModel;
import com.example.shivam.appetite.view_holders.GiViewHolder;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */

public class GiAdapter extends RecyclerView.Adapter<GiViewHolder> {
    public List<GiModel> giModels;
    public Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;



    public GiAdapter(Context context, List<GiModel> models){

        this.giModels = models;
        this.context = context;
    }

    @Override
    public GiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GiViewHolder giViewHolder = null;
        LayoutInflater li= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = li.inflate(R.layout.custom_gi_layout,parent,false);
        giViewHolder = new GiViewHolder(layoutView, giModels);
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
       storageReference = firebaseStorage.getReferenceFromUrl("gs://fir-login-96fe1.appspot.com/");
        return giViewHolder;
    }

    @Override
    public void onBindViewHolder(GiViewHolder holder, final int position) {
        String path = giModels.get(position).getImageurl().toString();
       holder.name_of_gi_text_view.setText(giModels.get(position).getName());
        Glide.with(context).using(new FirebaseImageLoader()).load(storageReference.child(path)).into(holder.gi_image_view);;
        /*holder.book_event_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"image is cicked",Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(context,BookingActivity.class);
               // intent.putExtra("name",eventModels.get(position).getName_of_event());



                //context.startActivity(intent);
            }
        });*/

        holder.state_of_gi_text_view.setText(giModels.get(position).getState());
        holder.category_of_gi_text_view.setText("Category: "+giModels.get(position).getCategory());
        //holder.gi_image_view.setBackgroundResource(R.mipmap.ic_launcher);
        holder.gi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DescGi.class);
                String name_of_gi = giModels.get(position).getName().toLowerCase().trim().replace(" ","");
                Toast.makeText(context,name_of_gi,Toast.LENGTH_SHORT).show();
                intent.putExtra("name",name_of_gi);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return giModels.size();
    }
}