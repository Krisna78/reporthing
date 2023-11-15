package com.example.reporthing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import Fragment.DasboardFragment;

public class SiswaActivity extends AppCompatActivity {

    private long backPress;
    private Toast backToast;


    DasboardFragment dasboardFragment;
    @Override
    public void onBackPressed() {
        if (backPress + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
        }else {
            backToast = Toast.makeText(getBaseContext(), "Klik dua kali untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPress = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        dasboardFragment = new DasboardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.parent_frame, dasboardFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}