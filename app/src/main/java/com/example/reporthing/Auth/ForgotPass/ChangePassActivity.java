package com.example.reporthing.Auth.ForgotPass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reporthing.Auth.AuthActivity;
import com.example.reporthing.Auth.models.ForgotPass.ForgotPassResponse;
import com.example.reporthing.Auth.models.VerifyPass.ChangePassResponse;
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.example.reporthing.databinding.ActivityChangePassBinding;
import com.google.gson.Gson;

import java.util.HashMap;

public class ChangePassActivity extends AppCompatActivity {
    ActivityChangePassBinding binding;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String getNISN = getIntent().getStringExtra("nisn");

        Button btn_verify = findViewById(R.id.btn_verify_pass);
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.passwordField.getText().toString();
                if (!password.isEmpty()) {
                    changePass(getNISN,password);
                } else {
                    Toast.makeText(ChangePassActivity.this, "Mohon isi Password terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void changePass(String nisn,String pass) {
        Toast.makeText(this, nisn+"     "+pass, Toast.LENGTH_SHORT).show();
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlForgotPass + "?id=" + nisn +"&password="+pass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 ChangePassResponse changePassResponse= gson.fromJson(response.toString(),ChangePassResponse.class);
                if (changePassResponse.getCode() == 200) {
                    Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ChangePassActivity.this, "NISN tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ChangePassActivity.this, "Mohon di isi", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",nisn);
                params.put("password",pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}