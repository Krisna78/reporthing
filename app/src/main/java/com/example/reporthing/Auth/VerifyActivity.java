package com.example.reporthing.Auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reporthing.Auth.models.VerifyPass.VerifyResponse;
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.google.gson.Gson;

import java.util.HashMap;

public class VerifyActivity extends AppCompatActivity {
    EditText txt_otp;
    Gson gson = new Gson();
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify2);
        txt_otp = findViewById(R.id.otp_field);
        String id = getIntent().getStringExtra("id");
        String otp = txt_otp.getText().toString();
        checkSiswa(id,otp);
    }
    private void checkSiswa(String ids,String otp) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlVerifyPass + "?id=" + ids + "&otp=" + otp, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(), ChangePassActivity.class);
                startActivity(intent);
                finish();
                /*VerifyResponse verifyResponse = gson.fromJson(response.toString(), VerifyResponse.class);
                if (verifyResponse.getCode() == 200) {

                } else {
                    Toast.makeText(VerifyActivity.this, "Kode OTP Salah", Toast.LENGTH_SHORT).show();
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VerifyActivity.this, "Error "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",ids);
                params.put("otp",otp);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}