package com.example.reporthing.Students;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reporthing.Auth.AuthActivity;
import com.example.reporthing.DatabaseHelper;
import com.example.reporthing.R;

public class StudentActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name,kelas,nisn;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name = findViewById(R.id.studentName);
        kelas = findViewById(R.id.studentClass);
        nisn = findViewById(R.id.studentNISN);


        Button out = findViewById(R.id.out);
        dbHelper = new DatabaseHelper(this);
        SharedPreferences sp = getSharedPreferences("isLogin",Context.MODE_PRIVATE);
        showProfileStudent(sp.getString("email",null),sp.getString("password",null));
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
                        builder.setMessage(R.string.confirm_dialog_logout)
                        .setTitle(R.string.confirm_logout)
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                sp.edit().putBoolean("isLogin",false).apply();
                                Intent intent = new Intent(getApplicationContext(),AuthActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.signOut) {
            Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void showProfileStudent(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from student where username = ? And password = ?", new String[]{username,password});
        String output = null;
        if (cursor.moveToFirst()) {
            String id = cursor.getString(0);
            String dataPassword = cursor.getString(1);
            String dataUsername = cursor.getString(2);
            String nama = cursor.getString(3);

            name.setText("Nama: "+nama);
            kelas.setText("Kelas: "+dataUsername);
            nisn.setText("NISN: "+id);
        }
    }
}