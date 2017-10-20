package com.example.shivam.appetite;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivam.appetite.adapters.CommentAdapter;
import com.example.shivam.appetite.adapters.GiAdapter;
import com.example.shivam.appetite.models.Comment;
import com.example.shivam.appetite.models.GiModel;
import com.example.shivam.appetite.models.Order;
import com.example.shivam.appetite.models.Seller;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class BuyGi extends AppCompatActivity {
    RecyclerView recyclerView;
    CommentAdapter commentAdapter;
    List<Comment> commentModels;
    FirebaseDatabase firebaseDatabase;
    Handler handler;
    Intent intent1;
    String sell_no,sell_price,sell_address;
    Seller s;
    EditText quantity;
    TextView address_text_view,price_text_view;
    ProgressBar progressBar;
    int progressBarTimer = 0;
    FirebaseStorage firebaseStorage;
    DatabaseReference databaseReference;
    LinearLayoutManager linearLayoutManager;
    Button payment_button,call,text;
    public void showDirections(double lat, double lng, double lat1, double lng1) {

        final Intent intent2 = new
                Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?" +
                "saddr=" + lat + "," + lng + "&daddr=" + lat1 + "," +
                lng1));
        intent2.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent2);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_gi);
        commentModels = new ArrayList<Comment>();
        recyclerView = (RecyclerView) findViewById(R.id.comment_recycle);
        intent1 = getIntent();
        quantity = (EditText)findViewById(R.id.quantity_edit_text);
        call = (Button)findViewById(R.id.call_seller);
        text  = (Button)findViewById(R.id.text_seller);
        price_text_view = (TextView)findViewById(R.id.price_text_view_buygi);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        address_text_view = (TextView)findViewById(R.id.location_text_view);
        sell_no =intent1.getStringExtra("seller_no");
        sell_price =intent1.getStringExtra("seller_price");
        sell_address =intent1.getStringExtra("seller_address");
        price_text_view.setText(sell_price);
        address_text_view.setText(sell_address);
        address_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // double lat = Double.parseDouble(latitude);
                //double lon = Double.parseDouble(longitude);
                showDirections(22.9868, 87.8550, 28.6773, 77.1123);
            }
        });
        Toast.makeText(BuyGi.this,sell_no,Toast.LENGTH_SHORT).show();
        linearLayoutManager = new LinearLayoutManager(this);
        Comment commentS = new Comment("great experience","9654772989","3","1234567890");
        commentModels.add(commentS);
        Comment commentS1 = new Comment("fake product","9654772989","1","1234567890");
        commentModels.add(commentS1);
        Comment commentS2 = new Comment("could be better","9654772989","0","1234567890");
        commentModels.add(commentS2);
        payment_button = (Button)findViewById(R.id.payment_button_buy_gi);
        commentAdapter = new CommentAdapter(BuyGi.this, commentModels);
        recyclerView.setAdapter(commentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        //address_text_view.setText(s.getAddress());
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = sell_no;
                String uri="tel:" +mobile;
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent2);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse("smsto:"));
                String mobile = sell_no;
                intent3.setType("vnd.android-dir/mms-sms");
                intent3.putExtra("sms_body","write your message here");
                intent3.putExtra("address",mobile);
                startActivity(intent3);
            }
        });
        payment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuyGi.this,PaymentSuccess.class);
                if (quantity.getText().toString().trim().length()!=0){
                    Order order = new Order("userContactNo",sell_no,sell_price,"5 days","shipped");
                    databaseReference.child("orders").push().setValue(order);

                    finish();
                    startActivity(intent);
                }else {
                    Toast.makeText(BuyGi.this,"Please enter the Quantity",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
