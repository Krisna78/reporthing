package com.example.reporthing.Students;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.reporthing.R;

public class SubjectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        String subjectName = getIntent().getStringExtra("subjectName");
        TextView subject = findViewById(R.id.subject_name);
        subject.setText(subjectName);

        String semesterName = getIntent().getStringExtra("semesters");
        TextView semester = findViewById(R.id.semester_name);
        semester.setText("Semester "+semesterName);

        String nilaiSumatif = getIntent().getStringExtra("sumatif");
        TextView sumatif = findViewById(R.id.nilai_sumatif);
        sumatif.setText(nilaiSumatif);

        String nilaiSumatifAkhir = getIntent().getStringExtra("sumatifAkhir");
        TextView sumatifAkhir = findViewById(R.id.nilai_sumatif_akhir);
        sumatifAkhir.setText(nilaiSumatifAkhir);

        String nilaiRapor = getIntent().getStringExtra("nilaiRapor");
        TextView rapor = findViewById(R.id.nilai_rapor);
        rapor.setText(nilaiRapor);
    }
}