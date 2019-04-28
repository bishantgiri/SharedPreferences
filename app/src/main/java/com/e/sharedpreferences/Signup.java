package com.e.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private Button btnSignup;
    private EditText etUsername, etPasswordSign, etConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.etUsername);
        etPasswordSign = findViewById(R.id.etPasswordSignup);
        etConfirmPassword = findViewById(R.id.etConfirmPasswordSignUp);
        btnSignup = findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register(){
            String pass1=etPasswordSign.getText().toString();
            String pass2=etConfirmPassword.getText().toString();

            SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            if(pass1.equals(pass2)){
                editor.putString("username",etUsername.getText().toString());
                editor.putString("password",etPasswordSign.getText().toString());
                editor.commit();

                Toast.makeText(this,"Successfully Registered",Toast.LENGTH_SHORT).show();
            }
            else{
                  Toast.makeText(this,"Password Doesn't Match",Toast.LENGTH_SHORT).show();
            }

    }
}
