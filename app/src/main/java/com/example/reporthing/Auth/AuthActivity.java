package com.example.reporthing.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.reporthing.DatabaseHelper;
import com.example.reporthing.R;
import com.example.reporthing.Students.StudentActivity;
import com.example.reporthing.Teachers.TeacherActivity;
import com.example.reporthing.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {
    public String reciveData;
    ActivityAuthBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.usernameField.getText().toString();
                String password = binding.passwordField.getText().toString();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(AuthActivity.this, "Masukkan Username dan Password", Toast.LENGTH_SHORT).show();
                } else {
                    String checkCredentials = databaseHelper.checkUsername(email,password);
                    binding.show.setText(checkCredentials);
                    if (checkCredentials.equals("student")) {
                        Toast.makeText(AuthActivity.this, "Selamat Datang, " + email, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                        startActivity(intent);
                        finish();
                    } else if(checkCredentials.equals("teacher")) {
                        Toast.makeText(AuthActivity.this, "Selamat Datang, " + email, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TeacherActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AuthActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}