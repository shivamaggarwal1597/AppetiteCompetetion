package com.example.shivam.appetite.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shivam.appetite.R;
import com.example.shivam.appetite.models.Comment;
import com.example.shivam.appetite.models.Seller;

import java.util.List;

/**
 * Created by shivam on 11/10/17.
 */


public class CommentViewHolder extends RecyclerView.ViewHolder{
    public Button comment_like_button;
    public TextView comment_text_view;
    public List<Comment> taskObj;
    public CommentViewHolder(final View itemView, List<Comment> commentModels) {
        super(itemView);
        this.taskObj = commentModels;
        comment_like_button = (Button)itemView.findViewById(R.id.custom_comment_like_button);
        comment_text_view = (TextView) itemView.findViewById(R.id.custom_comment_text_view_desc);

    }
}
