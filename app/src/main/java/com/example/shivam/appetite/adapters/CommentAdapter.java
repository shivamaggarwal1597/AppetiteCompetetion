package com.example.shivam.appetite.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shivam.appetite.BuyGi;
import com.example.shivam.appetite.R;
import com.example.shivam.appetite.models.Comment;
import com.example.shivam.appetite.models.Seller;
import com.example.shivam.appetite.view_holders.CommentViewHolder;
import com.example.shivam.appetite.view_holders.SellerViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {
    public List<Comment> commentModels;
    public Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    public CommentAdapter(Context context, List<Comment> models){

        this.commentModels = models;
        this.context = context;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommentViewHolder commentViewHolder = null;
        LayoutInflater li= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = li.inflate(R.layout.custom_comment_layout,parent,false);
        commentViewHolder = new CommentViewHolder(layoutView, commentModels);
        //firebaseStorage = FirebaseStorage.getInstance();
        //firebaseDatabase = FirebaseDatabase.getInstance();
        // databaseReference = firebaseDatabase.getReference();
        //  storageReference = firebaseStorage.getReferenceFromUrl("gs://whereismybholastaff.appspot.com/");
        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, final int position) {


        holder.comment_text_view.setText(commentModels.get(position).getComment_description().toString());
        holder.comment_like_button.setText("Likes ("+commentModels.get(position).getLikes().toString()+")");
        holder.comment_like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "increment like by 1", Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {

        return commentModels.size();
    }
}