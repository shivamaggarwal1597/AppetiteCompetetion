package com.example.shivam.appetite.models;

/**
 * Created by shivam on 11/10/17.
 */

public class Order {

    public String ordered_by_contact_no;
    public String orderered_to_contact_no;
    public String price_of_order;
    public String to_be_delivered_in;
    public String status_of_order;

    public Order(){

        }
    public String getOrdered_by_contact_no() {
        return ordered_by_contact_no;
    }

    public void setOrdered_by_contact_no(String ordered_by_contact_no) {
        this.ordered_by_contact_no = ordered_by_contact_no;
    }

    public String getOrderered_to_contact_no() {
        return orderered_to_contact_no;
    }

    public void setOrderered_to_contact_no(String orderered_to_contact_no) {
        this.orderered_to_contact_no = orderered_to_contact_no;
    }

    public String getPrice_of_order() {
        return price_of_order;
    }

    public void setPrice_of_order(String price_of_order) {
        this.price_of_order = price_of_order;
    }

    public String getTo_be_delivered_in() {
        return to_be_delivered_in;
    }

    public void setTo_be_delivered_in(String to_be_delivered_in) {
        this.to_be_delivered_in = to_be_delivered_in;
    }

    public String getStatus_of_order() {
        return status_of_order;
    }

    public void setStatus_of_order(String status_of_order) {
        this.status_of_order = status_of_order;
    }

    public Order(String ordered_by_contact_no, String orderered_to_contact_no, String price_of_order, String to_be_delivered_in, String status_of_order) {
        this.ordered_by_contact_no = ordered_by_contact_no;
        this.orderered_to_contact_no = orderered_to_contact_no;
        this.price_of_order = price_of_order;
        this.to_be_delivered_in = to_be_delivered_in;
        this.status_of_order = status_of_order;
    }
}
