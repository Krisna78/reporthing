package com.example.reporthing.Students;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reporthing.DB_url;
import com.example.reporthing.R;
import com.example.reporthing.Students.Adapters.JadwalDetailAdapter;
import com.example.reporthing.Students.Models.JadwalDetails.JadwalDetailData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JadwalDetailsActivity extends AppCompatActivity {
    ArrayList<JadwalDetailData> dataJadwalDetail;
    JadwalDetailData jadwalDetailModel;
    JadwalDetailAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_details);

        String hari = getIntent().getStringExtra("hari");
        String idKelas = getIntent().getStringExtra("nama_kelas");
//        Toast.makeText(this, hari + "   " + idKelas, Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.jadwal_detail_recycler);
        getJadwal(hari,idKelas);
    }
    private void getJadwal(String hari,String idKelas) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlJadwalDetails + "?hari=" + hari + "&kelas=" + idKelas, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dataJadwalDetail = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("jadwal");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jadwalDetailModel = new JadwalDetailData();
                        JSONObject data = jsonArray.getJSONObject(i);
                        jadwalDetailModel.setIdJadwal(data.getString("id_jadwal"));
                        jadwalDetailModel.setNamaMapel(data.getString("nama_mapel"));
                        jadwalDetailModel.setJamMulai(data.getString("jam_mulai"));
                        jadwalDetailModel.setJamSelesai(data.getString("jam_selesai"));
                        dataJadwalDetail.add(jadwalDetailModel);
                    }
                    linearLayoutManager = new LinearLayoutManager(JadwalDetailsActivity.this,LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    adapter = new JadwalDetailAdapter(JadwalDetailsActivity.this,dataJadwalDetail);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JadwalDetailsActivity.this, "Error : "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("hari",hari);
                params.put("kelas",idKelas);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}