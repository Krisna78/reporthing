package com.example.reporthing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import Fragment.DasboardFragment;
import Fragment.JadwalFragment;

public class SiswaActivity extends AppCompatActivity {

    private long backPress;
    private Toast backToast;

    BottomNavigationView bottomNavigationItemView;

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

        bottomNavigationItemView = findViewById(R.id.bottomNavigationView);
        bottomNavigationItemView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btn_home){
                    getFragment(new DasboardFragment());
                    return true;
                }else if (item.getItemId() == R.id.btn_jadwal){
                    getFragment(new JadwalFragment());
                    return true;
                }
                return false;
            }
        });
        getFragment(new DasboardFragment());
    }

    private void getFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.parent_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}