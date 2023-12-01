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
import com.example.reporthing.Auth.models.ForgotPass.ForgotPassResponse;
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.example.reporthing.databinding.ActivityForgotPassBinding;
import com.google.gson.Gson;

import java.util.HashMap;

public class ForgotPassActivity extends AppCompatActivity {
    Gson gson = new Gson();
    ActivityForgotPassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btn_check = findViewById(R.id.btn_check);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNisn = binding.nisnField.getText().toString();
                if (!getNisn.isEmpty()) {
                    checkNISN(getNisn);
                } else {
                    Toast.makeText(ForgotPassActivity.this, "Mohon isi NISN terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void checkNISN(String nisn) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlForgotPass + "?id=" + nisn, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ForgotPassResponse forgotPassResponse = gson.fromJson(response.toString(),ForgotPassResponse.class);
                if (forgotPassResponse.getCode() == 200) {
                    Intent intent = new Intent(getApplicationContext(), ChangePassActivity.class);
                    intent.putExtra("nisn",forgotPassResponse.getForgotPass().get(0).getNisn());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(ForgotPassActivity.this, "NISN tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ForgotPassActivity.this, "Mohon di isi", Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",nisn);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}