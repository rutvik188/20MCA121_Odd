package com.rutvik.a20mca121_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;

public class SplashActivity extends AppCompatActivity {

String Str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() { // Hold For 3 second
            @Override
            public void run() {

                SharedPreferences sharedPreferences=getSharedPreferences("MyPref",Context.MODE_PRIVATE);
                Str=sharedPreferences.getString("user","Wrong"); // sharedPreferences for save Username if user viste next timeno need to login

                if (Str.equals("Wrong")){
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(SplashActivity.this,HomeActivity.class);
                    startActivity(intent);
                }


            }
        },3000);




    }
}