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
    private EditText etUsername, etPassword, etConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignup = findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
    }

    private Void SignUp(){

            SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            String pass1=etPassword.getText().toString();
            String pass2=etConfirmPassword.getText().toString();


            if(pass1==pass2){
                editor.putString("username",etUsername.getText().toString());
                editor.putString("password",etPassword.getText().toString());
                editor.commit();

                Toast.makeText(this,"Registerd Successfully",Toast.LENGTH_SHORT).show();
            }else{
                  Toast.makeText(this,"Password Doesn't Match",Toast.LENGTH_SHORT).show();
            }

    }
}
