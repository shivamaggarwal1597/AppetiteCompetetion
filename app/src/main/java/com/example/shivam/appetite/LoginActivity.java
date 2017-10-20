package com.example.shivam.appetite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText uname,pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        uname= (EditText) findViewById(R.id.etusername);
        pass= (EditText) findViewById(R.id.etpassword);
        login=(Button)findViewById(R.id.btnlogin);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(uname.getText().toString().length()<3){
            uname.setError("uname should be greater than 3 alphabet");
            return;
        }

        if(pass.getText().toString().length()<3){
            pass.setError("pass should be greater than 3 alphabet");
            return;
        }
        if(uname.getText().toString().equals("admin")&&pass.getText().toString().equals("admin")){

            Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Wrong Id Password",Toast.LENGTH_SHORT).show();
        }
    }
}
