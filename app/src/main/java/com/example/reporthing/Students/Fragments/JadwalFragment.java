package com.example.reporthing.Students.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.reporthing.Students.Adapters.JadwalAdapter;
import com.example.reporthing.Students.Models.Semesters.SemesterData;
import com.example.reporthing.Students.Models.jadwals.JadwalData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JadwalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JadwalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<JadwalData> dataJadwal;
    SharedPreferences sp;
    JadwalAdapter adapter;
    JadwalData jadwalModel;
    LinearLayoutManager linearLayoutManager;

    public JadwalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JadwalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JadwalFragment newInstance(String param1, String param2) {
        JadwalFragment fragment = new JadwalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);
        sp = getActivity().getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        String idClass = sp.getString("kelas",null);

        recyclerView = view.findViewById(R.id.recyclerJadwal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataJadwal = new ArrayList<>();
        JadwalAdapter jadwalAdapter = new JadwalAdapter(getContext(),dataJadwal);
        jadwalAdapter.notifyDataSetChanged();
        getJadwal(idClass);
        return view;
    }
    private void getJadwal(String kelas) {
        StringRequest request = new StringRequest(Request.Method.GET, DB_url.urlJadwal + "?kelas=" + kelas, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dataJadwal = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("jadwal");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jadwalModel = new JadwalData();
                        JSONObject data = jsonArray.getJSONObject(i);
                        jadwalModel.setNamaKelas(data.getString("nama_kelas"));
                        jadwalModel.setHari(data.getString("hari"));
                        dataJadwal.add(jadwalModel);
                    }
                    linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    adapter = new JadwalAdapter(getActivity(),dataJadwal);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected HashMap<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("kelas",kelas);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}