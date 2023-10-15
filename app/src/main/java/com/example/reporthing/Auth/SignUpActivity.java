package com.example.reporthing.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.reporthing.DatabaseHelper;
import com.example.reporthing.R;
import com.example.reporthing.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = binding.id.getText().toString();
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                String name = binding.nama.getText().toString();
                if(id.isEmpty()||password.isEmpty()||username.isEmpty()||name.isEmpty())
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = databaseHelper.insertData(id,username,password,name);
                    if (insert == true) {
                        Intent intent = new Intent(getApplicationContext(),AuthActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, AuthActivity.class);
                startActivity(intent);
            }
        });
    }
}