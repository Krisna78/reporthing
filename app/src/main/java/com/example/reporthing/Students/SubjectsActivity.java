package com.example.reporthing.Students;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
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
import com.example.reporthing.Students.Adapters.SubjectAdapter;
import com.example.reporthing.Students.Models.Subjects.SubjectResponse;
import com.example.reporthing.Students.Models.Subjects.SubjectsData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubjectsActivity extends AppCompatActivity {
    TextView txtIpas,txtBindo,txtMtk,txtMusik,txtTari,txtRupa,txtTeater,txtPjok,txtBing;
    Gson gson = new Gson();
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<SubjectsData> dataSubject;
    SubjectAdapter adapter;
    SubjectsData subjectModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        String nisnCode = getIntent().getStringExtra("nisn");
        String thnAjaranCode = getIntent().getStringExtra("thn_ajaran");
        String smst = getIntent().getStringExtra("semester");

        recyclerView = findViewById(R.id.subject_recyclerview);
        getSubjects(nisnCode,thnAjaranCode,smst);
        /*showSubjectValue(nisnCode,thnAjaranCode,smst);*/
    }
    private void getSubjects(String nisn,String thnAjaran,String semesters) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlSubjects + "?id=" + nisn + "&thn_ajaran=" + thnAjaran+ "&semester=" + semesters, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dataSubject = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("subjects");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        subjectModel = new SubjectsData();
                        JSONObject data = jsonArray.getJSONObject(i);
                        subjectModel.setSemester(data.getString("semester"));
                        subjectModel.setNamaMapel(data.getString("nama_mapel"));
                        subjectModel.setNilaiRapor(data.getString("nilai_rapor"));
                        subjectModel.setSumatif(data.getString("sumatif"));
                        subjectModel.setSumatifAkhir(data.getString("sumatif_akhir"));
                        dataSubject.add(subjectModel);
                    }
                    if(dataSubject.isEmpty()) {
                        setContentView(R.layout.empty_data_layout);
                    } else {
                        linearLayoutManager = new LinearLayoutManager(SubjectsActivity.this,LinearLayoutManager.VERTICAL,false);
                        recyclerView.setLayoutManager(linearLayoutManager);

                        adapter = new SubjectAdapter(SubjectsActivity.this, dataSubject);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SubjectsActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",nisn);
                params.put("thn_ajaran",thnAjaran);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
    /*private void showSubjectValue(String id,String thn_ajaran,String semester) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlSubjects + "?id=" + id + "&thn_ajaran=" + thn_ajaran + "&semester=" + semester, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                SubjectResponse subjectResponse = gson.fromJson(response.toString(), SubjectResponse.class);
                txtIpas.setText(subjectResponse.getSubjects().get(0).getIpas());
                txtBindo.setText(subjectResponse.getSubjects().get(0).getBahasaIndonesia());
                txtMtk.setText(subjectResponse.getSubjects().get(0).getMtk());
                txtMusik.setText(subjectResponse.getSubjects().get(0).getSeniMusik());
                txtRupa.setText(subjectResponse.getSubjects().get(0).getSeniRupa());
                txtTari.setText(subjectResponse.getSubjects().get(0).getSeniTari());
                txtTeater.setText(subjectResponse.getSubjects().get(0).getSeniTeater());
                txtPjok.setText(subjectResponse.getSubjects().get(0).getPjok());
                txtBing.setText(subjectResponse.getSubjects().get(0).getBahasaInggris());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SubjectsActivity.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("id",id);
                params.put("thn_ajaran",thn_ajaran);
                params.put("semester",semester);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }*/
}