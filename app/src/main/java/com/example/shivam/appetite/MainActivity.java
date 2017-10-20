package com.example.shivam.appetite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button buy_btn,sell_btn,show_on_map_btn;
    EditText uname,pass;
    Button login,register;
    TextView authLogIn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname= (EditText) findViewById(R.id.uetusername);
        pass= (EditText) findViewById(R.id.uetpassword);
        login= (Button) findViewById(R.id.ubtnlogin);
        register= (Button) findViewById(R.id.ubtnsignup);
        authLogIn= (TextView) findViewById(R.id.autlogin);
        authLogIn.setOnClickListener(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        login.setOnClickListener(this);
        authLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });



    }
    @Override
    public void onClick(View view) {
        String user=uname.getText().toString();
        String password=pass.getText().toString();
        if(user.length()!=10){
            uname.setError("Mobile should be 10 digits");
            return;
        }
        if(password.length()<3){
            uname.setError("Password should be more than 3 digits");
            return;
        }
        switch (view.getId()){
            case R.id.ubtnlogin:
                login();
                break;
            case R.id.ubtnsignup:
                register();
                break;
        }
    }

    private void login() {
        Intent i=new Intent(this,ShowGiList.class);
        startActivity(i);
    }
    private void register() {
        Toast.makeText(this,"Successfully registered",Toast.LENGTH_SHORT).show();
        login();
    }
}
