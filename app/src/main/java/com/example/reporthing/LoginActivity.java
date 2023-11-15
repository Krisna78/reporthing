package com.example.reporthing;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private long backPress;
    private Toast backToast;




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
        setContentView(R.layout.activity_login);
    }


    public void masuk(View view){
        TextInputEditText editText = findViewById(R.id.teksinputedit1);
        String inputtext = editText.getText().toString().trim();

        TextInputEditText editText2 = findViewById(R.id.teksinputedit2);
        String inputtext2 = editText2.getText().toString().trim();
        if(inputtext.isEmpty() && inputtext2.isEmpty()){
            editText.setError("Data tidak boleh kosong");
            editText2.setError("Data tidak boleh kosong");
        } else{
            Intent masuk = new Intent(LoginActivity.this, SiswaActivity.class);
            startActivity(masuk);
            finish();
        }
    }

}