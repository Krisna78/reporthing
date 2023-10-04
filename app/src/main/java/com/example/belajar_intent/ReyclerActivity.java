package com.example.belajar_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adaptercard adaptercard;
    private ArrayList<cardmodel> cardmodels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reycler);

        dataInitialize();

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptercard = new Adaptercard(this, cardmodels);
        recyclerView.setAdapter(adaptercard);
        adaptercard.notifyDataSetChanged();


    }

    private void dataInitialize(){
        cardmodels = new ArrayList<cardmodel>();
        cardmodels.add(new cardmodel("Dania Angga","","","","","","","", R.drawable.angga));
        cardmodels.add(new cardmodel("Naufal I'mal", R.drawable.naufal));
        cardmodels.add(new cardmodel("Bayu Krisna", R.drawable.bayu));
        cardmodels.add(new cardmodel("Yohanes Krisna D", R.drawable.krisna));
        cardmodels.add(new cardmodel("Mochamad Alfan", R.drawable.alfan));
        cardmodels.add(new cardmodel("Sevri Vendrian", R.drawable.sevri));
        cardmodels.add(new cardmodel("Fathur Rahman H", R.drawable.hakim));
        cardmodels.add(new cardmodel("Rama Diputer", R.drawable.rama));
    }
}