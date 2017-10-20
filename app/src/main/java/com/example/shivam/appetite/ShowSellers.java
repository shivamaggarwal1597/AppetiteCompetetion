package com.example.shivam.appetite;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.shivam.appetite.adapters.GiAdapter;
import com.example.shivam.appetite.adapters.SellerAdapter;
import com.example.shivam.appetite.models.GiModel;
import com.example.shivam.appetite.models.Seller;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class ShowSellers extends AppCompatActivity {
    RecyclerView recyclerView;
    SellerAdapter sellerAdapter;
    List<Seller> sellerModels;
    FirebaseDatabase firebaseDatabase;
    Intent intent;
    String name_gi;
    Handler handler;
    ProgressBar progressBar;
    int progressBarTimer = 0;
    FirebaseStorage firebaseStorage;
    DatabaseReference databaseReference;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sellers);
        sellerModels = new ArrayList<Seller>();
        recyclerView = (RecyclerView) findViewById(R.id.show_sellers_recycle);
        linearLayoutManager = new LinearLayoutManager(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        intent= getIntent();
        name_gi = intent.getStringExtra("name_of_gi");
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("sellers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    sellerModels.clear();
                    Seller sell =ds.getValue(Seller.class);
                    if (sell.getGi_name().equals(name_gi)) {
                        sellerModels.add(sell);
                        sellerAdapter = new SellerAdapter(ShowSellers.this, sellerModels);
                        recyclerView.setAdapter(sellerAdapter);
                        recyclerView.setLayoutManager(linearLayoutManager);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
