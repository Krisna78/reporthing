package com.example.reporthing.Students;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import com.example.reporthing.R;
import com.example.reporthing.Students.Models.ProfileResponse;
import com.google.gson.Gson;

import java.util.HashMap;

public class StudentActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name,kelas,nisn;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name = findViewById(R.id.studentName);
        kelas = findViewById(R.id.studentClass);
        nisn = findViewById(R.id.studentNISN);
        Button out = findViewById(R.id.out);

        SharedPreferences sp = getSharedPreferences("isLogin",Context.MODE_PRIVATE);
        showProfile(sp.getString("id",null));

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
                        builder.setMessage(R.string.confirm_dialog_logout)
                        .setTitle(R.string.confirm_logout)
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                sp.edit().putBoolean("isLogin",false).apply();
                                Intent intent = new Intent(getApplicationContext(),AuthActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.signOut) {
            Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void showProfile(String profileID) {
        String url = "http://10.10.185.177/reporthingAPI/showProfile.php";
        StringRequest request = new StringRequest(Request.Method.GET, url + "?id=" + profileID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ProfileResponse profileResponse = gson.fromJson(response.toString(),ProfileResponse.class);
                name.setText("Nama: " + profileResponse.getUserProfile().get(0).getNamaSiswa());
                kelas.setText("Kelas: "+ profileResponse.getUserProfile().get(0).getNamaKelas());
                nisn.setText("NISN: "+ profileResponse.getUserProfile().get(0).getNisn());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StudentActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("id",profileID);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}