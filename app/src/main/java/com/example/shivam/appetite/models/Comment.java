package com.example.shivam.appetite.models;

/**
 * Created by shivam on 11/10/17.
 */

public class Comment {

    public String comment_description;
    public String posted_by_contact_no;
    public String likes;
    public String contact_no_of_seller;

    public String getContact_no_of_seller() {
        return contact_no_of_seller;
    }

    public void setContact_no_of_seller(String contact_no_of_seller) {
        this.contact_no_of_seller = contact_no_of_seller;
    }

    public Comment(String comment_description, String posted_by_contact_no, String likes, String contact_no_of_seller) {
        this.comment_description = comment_description;
        this.posted_by_contact_no = posted_by_contact_no;
        this.likes = likes;
        this.contact_no_of_seller = contact_no_of_seller;
    }

    public Comment(){

    }
    public String getComment_description() {
        return comment_description;
    }

    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }

    public String getPosted_by_contact_no() {
        return posted_by_contact_no;
    }

    public void setPosted_by_contact_no(String posted_by_contact_no) {
        this.posted_by_contact_no = posted_by_contact_no;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
