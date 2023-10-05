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
        cardmodels.add(new cardmodel("Asep Ackerman","Dania Angga Barry Lana","Laki-Laki","Islam","03-10-2003","Dusun Sumber Tengah","anggabarry87@gmail.com","12345dff", R.drawable.angga));
        cardmodels.add(new cardmodel("Dayat Satoru","Naufal I'mal Maulana","Laki-Laki","Islam","21-09-2003","Tegal Besar","player1@gmail.com","absf842jd", R.drawable.naufal));
        cardmodels.add(new cardmodel("Uzumaki Ubay","Bayu Krisna Dwi F","Laki-Laki","Islam","12-12-2012","Patrang","player2@gmail.com","ajcmsh94", R.drawable.bayu));
        cardmodels.add(new cardmodel("Hesh_CP","Yohanes Krisna D","Laki-Laki","Katolik","01-01-2001","Monstand","player3@gmail.com","sjcma497sh", R.drawable.krisna));
        cardmodels.add(new cardmodel("Bayar", "Mochamad Alfan Muawad","Laki-Laki","Islam","03-03-2003","Ciamis","player4@gmail.com","abfk39as",R.drawable.alfan));
        cardmodels.add(new cardmodel("Kepeng Nganan","Sevri Vendrian Achmad J","Laki-Laki","Islam","08-08-1998","Bondowoso","player5@gmail.com","dk20rhd", R.drawable.sevri));
        cardmodels.add(new cardmodel("C baikhati","Fathur Rachman Hakim","Laki-Laki","Islam","15-05-1945","Banyuangi","player6@gmail.com","smnd375", R.drawable.hakim));
        cardmodels.add(new cardmodel("Mcd","Rama Diputra","Laki-Laki","Islam","12-03-2004","Banyuangi","player7@gmail.com","smcbdydo1856", R.drawable.rama));
    }
}