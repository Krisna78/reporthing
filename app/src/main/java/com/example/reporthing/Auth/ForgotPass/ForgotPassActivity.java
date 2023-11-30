package com.example.reporthing.Auth.ForgotPass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reporthing.Auth.VerifyActivity;
import com.example.reporthing.Auth.models.ForgotPass.ForgotResponse;
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.google.gson.Gson;

import java.util.HashMap;

public class ForgotPassActivity extends AppCompatActivity {
    private Button btn;
    private EditText txtNISN,txtEmail;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        txtNISN = findViewById(R.id.nisn_field);
        txtEmail = findViewById(R.id.email_field);

        btn = findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNISN = txtNISN.getText().toString();
                String getEmail = txtEmail.getText().toString();
                sendOTP(getNISN,getEmail);
            }
        });
    }
    private void sendOTP(String id,String email){
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlForgotPass + "?id=" + id +"&email="+email, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ForgotResponse forgotResponse = gson.fromJson(response.toString(),ForgotResponse.class);
                if (forgotResponse.getCode() == 200) {
                    Intent intent = new Intent(getApplicationContext(), VerifyActivity.class);
                    intent.putExtra("id",forgotResponse.getUserProfile().get(0).getNisn());
                    Toast.makeText(ForgotPassActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else if (forgotResponse.getCode() == 400) {
                    Toast.makeText(ForgotPassActivity.this, "Tidak di temukan data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ForgotPassActivity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",id);
                params.put("email",email);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}