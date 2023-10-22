package com.example.reporthing.Auth;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;

import com.example.reporthing.DatabaseHelper;
import com.example.reporthing.R;
import com.example.reporthing.Students.StudentActivity;
import com.example.reporthing.Teachers.TeacherActivity;
import com.example.reporthing.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {
    private boolean isBackPressedOnce = false;
    public String reciveData;
    public String email,password;
    SharedPreferences sharedPreferences;
    ActivityAuthBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        sharedPreferences = getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLogin",false) != false) {
            String sessionEmail = sharedPreferences.getString("email",null);
            String checkCredentials = databaseHelper.checkUsername(sharedPreferences.getString("email",null),sharedPreferences.getString("password",null));
            if (checkCredentials.equals("student")) {
                Toast.makeText(AuthActivity.this, "Selamat Datang, " + sessionEmail, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
                finish();
            } else if(checkCredentials.equals("teacher")) {
                Toast.makeText(AuthActivity.this, "Selamat Datang, " + sessionEmail, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TeacherActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(AuthActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.usernameField.getText().toString();
                password = binding.passwordField.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(AuthActivity.this, "Masukkan Username dan Password", Toast.LENGTH_SHORT).show();
                } else {
                    String checkCredentials = databaseHelper.checkUsername(email,password);
                    if (checkCredentials.equals("student")) {
                        Toast.makeText(AuthActivity.this, "Selamat Datang, " + email, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                        startActivity(intent);
                        editor.putString("email",email);
                        editor.putString("password",password);
                        editor.putBoolean("isLogin",true);
                        editor.apply();
                        finish();
                    } else if(checkCredentials.equals("teacher")) {
                        Toast.makeText(AuthActivity.this, "Selamat Datang, " + email, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TeacherActivity.class);
                        startActivity(intent);
                        editor.putString("email",email);
                        editor.putString("password",password);
                        editor.putBoolean("isLogin",true);
                        editor.apply();
                        finish();
                    } else {
                        Toast.makeText(AuthActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed();
            return;
        }
        Toast.makeText(this, "Tekan Lagi Tombol Kembali", Toast.LENGTH_SHORT).show();
        isBackPressedOnce = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isBackPressedOnce = false;
            }
        },1000);
    }
}