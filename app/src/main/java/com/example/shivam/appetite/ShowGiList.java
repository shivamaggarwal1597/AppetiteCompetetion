package com.example.shivam.appetite;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.shivam.appetite.adapters.GiAdapter;
import com.example.shivam.appetite.models.GiModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class ShowGiList extends AppCompatActivity {
//In this the list of 5 Gi would be shown
RecyclerView recyclerView;
    GiAdapter giAdapter;
    List<GiModel> giModels;
    FirebaseDatabase firebaseDatabase;
    Handler handler;
    ProgressBar progressBar;
    int progressBarTimer = 0;
    Button show;
    FirebaseStorage firebaseStorage;
    DatabaseReference databaseReference;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gi_list);
        giModels = new ArrayList<GiModel>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        linearLayoutManager = new LinearLayoutManager(this);
       show = (Button)findViewById(R.id.show_on_map_btn);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ShowGiList.this,MapsActivity.class);
                startActivity(in);
            }
        });
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("gi_list").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                giModels.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    giModels.add(ds.getValue(GiModel.class));
                }
                giAdapter = new GiAdapter(ShowGiList.this, giModels);
                recyclerView.setAdapter(giAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

         }
}
