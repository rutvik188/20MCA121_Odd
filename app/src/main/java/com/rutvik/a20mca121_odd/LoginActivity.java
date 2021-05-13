package com.rutvik.a20mca121_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,pass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//two edit text and BUtton
        username=findViewById(R.id.edUsername);
        pass=findViewById(R.id.edPass);
        btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if user enter admin and admin then go to homeActivity

                if(username.getText().toString().equals("admin")&&pass.getText().toString().equals("admin"))
                {
                    //set sharedPreferences for username as user
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("user",username.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    //if user Enter Wrong data
                    Toast.makeText(LoginActivity.this, "Please right Data!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}