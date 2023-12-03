package com.example.reporthing.Auth.ForgotPass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.example.reporthing.databinding.ActivityForgotPassBinding;
import com.google.gson.Gson;

import java.util.HashMap;

public class ForgotPassActivity extends AppCompatActivity {
    Gson gson = new Gson();
    ActivityForgotPassBinding binding;

    private EditText txt_username, txt_password, txt_repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txt_username = findViewById(R.id.nisn_field);
        txt_password = findViewById(R.id.txt_password);
        txt_repassword = findViewById(R.id.password_field);

        Button btn_check = findViewById(R.id.btn_reset);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txt_username.getText().toString();
                String pass = txt_password.getText().toString();
                String passVerify = txt_repassword.getText().toString();
                if (!username.isEmpty()) {
                    if (pass.equals(passVerify)) {
                        checkNISN(username,pass);
                    } else{
                        Toast.makeText(ForgotPassActivity.this, "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ForgotPassActivity.this, "Mohon isi NISN terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void checkNISN(String username, String pass) {
        StringRequest request = new StringRequest(Request.Method.POST, DB_url.urlForgotPass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ForgotPassResponse forgotPassResponse = gson.fromJson(response.toString(),ForgotPassResponse.class);
                if (forgotPassResponse.getCode() == 200) {
                    Toast.makeText(ForgotPassActivity.this, "Password berhasil diubah", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                    startActivity(intent);
                    finish();
                } else if (forgotPassResponse.getCode() == 400){
                    Toast.makeText(ForgotPassActivity.this, "Username tidak terdaftar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ForgotPassActivity.this, "Username tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ForgotPassActivity.this, "Mohon di isi" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("username", username);
                params.put("password",pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}