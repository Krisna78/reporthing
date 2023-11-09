package com.example.reporthing.Auth;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reporthing.Auth.models.UserResponse;
import com.example.reporthing.DB_url;
import com.example.reporthing.Students.StudentActivity;
import com.example.reporthing.databinding.ActivityAuthBinding;
import com.google.gson.Gson;

import java.util.HashMap;

public class AuthActivity extends AppCompatActivity {
    private boolean isBackPressedOnce = false;
    public String userName,password;
    SharedPreferences sharedPreferences;
    ActivityAuthBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLogin",false) != false) {
            String sessionEmail = sharedPreferences.getString("username",null);
            Toast.makeText(AuthActivity.this, "Selamat Datang, " + sessionEmail, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
            startActivity(intent);
            finish();
        }

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = binding.usernameField.getText().toString();
                password = binding.passwordField.getText().toString();
                if (userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(AuthActivity.this, userName, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(AuthActivity.this, "Masukkan Username dan Password", Toast.LENGTH_SHORT).show();
                } else if (!(userName.isEmpty() || password.isEmpty()) ){
                    Gson gson = new Gson();
                    StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlAuth + "?username=" + userName + "&password=" + password, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            UserResponse authResponse = gson.fromJson(response.toString(), UserResponse.class);
                            if (authResponse.getCode() == 200) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                Toast.makeText(AuthActivity.this, "Selamat Datang, " + authResponse.getUserList().get(0).getUsername(), Toast.LENGTH_SHORT).show();
                                editor.putString("id",authResponse.getUserList().get(0).getIdUserSiswa());
                                editor.putString("nisn",authResponse.getUserList().get(0).getNisn());
                                editor.putString("username",userName);
                                editor.putString("password",password);
                                editor.putBoolean("isLogin",true);
                                editor.apply();
                                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                                startActivity(intent);
                                finish();
                            } else if (authResponse.getCode() == 401) {
                                Toast.makeText(AuthActivity.this, "Password anda salah", Toast.LENGTH_SHORT).show();
                            } else if (authResponse.getCode() == 404) {
                                Toast.makeText(AuthActivity.this, "Username tidak terdaftar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AuthActivity.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    {
                        @Nullable
                        @Override
                        protected HashMap<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> params = new HashMap<>();
                            params.put("username",userName);
                            params.put("password",password);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
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
        binding.forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this,ForgotPassActivity.class);
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