package com.e.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etUsername_Login, etPassword_Login;
    private Button btnSignup_Login,btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername_Login=findViewById(R.id.etUser_Login);
        etPassword_Login=findViewById(R.id.etPass_Login);
        btnSignup_Login = findViewById(R.id.signUp_login);
        btnLogin=findViewById(R.id.btnLogin);


        btnSignup_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Signup.class);
                startActivity(i);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }
    private void checkUser(){
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        String usernam=sharedPreferences.getString("username","");
        String passwor=sharedPreferences.getString("password","");
        String uname =etUsername_Login.getText().toString();
        String passw =etPassword_Login.getText().toString();
        if(usernam.equals(uname) ||
        passwor.equals(passw))
        {
            Toast.makeText(Login.this,"Welcome",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(Login.this,"Username and password dosen't mathch",Toast.LENGTH_SHORT).show();
        }


    }
}
