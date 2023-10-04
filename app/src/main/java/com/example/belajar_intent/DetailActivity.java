package com.example.belajar_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView hasilfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        int image = getIntent().getIntExtra("image", 0);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String fn = intent.getStringExtra("FN");
        String agamaa = intent.getStringExtra("AGAMA");
        String tgl_lahir = intent.getStringExtra("TGL");
        String alamatt = intent.getStringExtra("ALAMAT");
        String emaill = intent.getStringExtra("EMAIL");
        String pass = intent.getStringExtra("PASS");
        String gender = intent.getExtras().getString("GENDER");


        ImageView imageView = findViewById(R.id.hasil_foto);
        TextView hasil1 = findViewById(R.id.hasil_username);
        TextView hasil2 = findViewById(R.id.hasil_fullnama);
        TextView hasil3 = findViewById(R.id.hasil_agama);
        TextView hasil4 = findViewById(R.id.hasil_tanggal_lahir);
        TextView hasil5 = findViewById(R.id.hasil_alamat);
        TextView hasil6 = findViewById(R.id.hasil_email);
        TextView hasil7 = findViewById(R.id.hasil_password);
        TextView hasil8 = findViewById(R.id.hasil_gender);

        imageView.setImageResource(image);
        hasil1.setText(name);
        hasil2.setText(fn);
        hasil3.setText(agamaa);
        hasil4.setText(tgl_lahir);
        hasil5.setText(alamatt);
        hasil6.setText(emaill);
        hasil7.setText(pass);
        hasil8.setText(gender);

    }
}