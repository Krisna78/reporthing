package com.example.belajar_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_tanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    ImageView imageView, imageView2;
    Button button;
    Button button2;

    RadioGroup allgender;
    RadioButton gender;
    int image=0;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        builder = new AlertDialog.Builder(this);

        txt_tanggal = (EditText) findViewById(R.id.tanggal_lahir);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        txt_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        imageView = findViewById(R.id.foto);
        button = findViewById(R.id.btn_foto);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA
            },100);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        allgender = findViewById(R.id.radio_grup);

        final EditText username = findViewById(R.id.txt_username);
        final EditText fullname = findViewById(R.id.txt_fullname);
        final EditText agama = findViewById(R.id.txt_agama);
        final EditText tanggal_lahir = findViewById(R.id.tanggal_lahir);
        final EditText alamat = findViewById(R.id.txt_alamat);
        final EditText email = findViewById(R.id.txt_email);
        final EditText password = findViewById(R.id.txt_password);

        ImageView img = findViewById(R.id.foto);
        button2 = findViewById(R.id.btn_daftarr);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setTitle("Konfirmasi")
                        .setMessage("Apakah anda ingin melihat detail?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                int radioid = allgender.getCheckedRadioButtonId();
                                gender = (RadioButton) findViewById(radioid);

                                String name = username.getText().toString();
                                String fn = fullname.getText().toString();
                                String agamaa = agama.getText().toString();
                                String tgl_lahir = tanggal_lahir.getText().toString();
                                String alamatt = alamat.getText().toString();
                                String emaill = email.getText().toString();
                                String pass = password.getText().toString();
                                //   int foto =  img.getIn.;


                                Intent intent = new Intent(RegisterActivity.this, DetailActivity.class);
                                intent.putExtra("NAME", name);
                                intent.putExtra("FN", fn);
                                intent.putExtra("AGAMA",agamaa);
                                intent.putExtra("TGL", tgl_lahir);
                                intent.putExtra("ALAMAT", alamatt);
                                intent.putExtra("EMAIL", emaill);
                                intent.putExtra("PASS", pass);
                                intent.putExtra("GENDER",gender.getText().toString());
                                //     intent.putExtra("image", );



                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent2);
                            }
                        })
                        .show();

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    private void showDateDialog() {
        Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                txt_tanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}

