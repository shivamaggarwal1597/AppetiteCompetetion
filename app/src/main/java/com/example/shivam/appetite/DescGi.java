package com.example.shivam.appetite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.shivam.appetite.models.GiModel;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DescGi extends AppCompatActivity {
    Button proceed;
    TextView name_text,state_text_desc_gi,category_text_desc_gi,description_text_desc_gi;
    ImageView image_desc_gi;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    GiModel g;
    String pass;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_gi);
        state_text_desc_gi = (TextView)findViewById(R.id.text_view_state_desc_gi);
        category_text_desc_gi = (TextView)findViewById(R.id.text_view_category_desc_gi);
        description_text_desc_gi = (TextView)findViewById(R.id.text_view_description_desc_gi);
        image_desc_gi = (ImageView)findViewById(R.id.image_view_desc_gi);
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReferenceFromUrl("gs://fir-login-96fe1.appspot.com/");
        intent = getIntent();
        name_text = (TextView)findViewById(R.id.name_text_desc_gi);

        final String id_name_gi=intent.getStringExtra("name");
        pass = id_name_gi;
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("gi_list").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               g = dataSnapshot.child(id_name_gi).getValue(GiModel.class);
                state_text_desc_gi.setText(g.getState());
                category_text_desc_gi.setText(g.getCategory());
                description_text_desc_gi.setText(g.getDescription());
                String path = g.getImageurl().toString();
                Toast.makeText(DescGi.this,path,Toast.LENGTH_SHORT).show();
                Glide.with(DescGi.this).using(new FirebaseImageLoader()).load(storageReference.child(path)).into(image_desc_gi);
                name_text.setText(g.getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        proceed = (Button)findViewById(R.id.choose_seller_button_desc);
        proceed.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DescGi.this,ShowSellers.class);
                intent1.putExtra("name_of_gi",id_name_gi);
                Toast.makeText(DescGi.this,id_name_gi,Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            }
        });
    }
}
