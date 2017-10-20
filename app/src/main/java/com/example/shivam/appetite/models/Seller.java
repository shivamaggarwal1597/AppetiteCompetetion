package com.example.shivam.appetite.models;

/**
 * Created by shivam on 11/10/17.
 */

public class Seller {
    public String seller_name;
    public String gi_name;
    public String seller_price;
    public String seller_contact_no;
    public String address;
    public String latitude;
    public String longitude;
    public String rating;

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getGi_name() {
        return gi_name;
    }

    public void setGi_name(String gi_name) {
        this.gi_name = gi_name;
    }

    public String getSeller_price() {
        return seller_price;
    }

    public void setSeller_price(String seller_price) {
        this.seller_price = seller_price;
    }

    public String getSeller_contact_no() {
        return seller_contact_no;
    }

    public void setSeller_contact_no(String seller_contact_no) {
        this.seller_contact_no = seller_contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Seller(){

    }
    public Seller(String seller_name, String gi_name, String seller_price, String seller_contact_no, String address, String latitude, String longitude, String rating) {
        this.seller_name = seller_name;
        this.gi_name = gi_name;
        this.seller_price = seller_price;
        this.seller_contact_no = seller_contact_no;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
    }
}
