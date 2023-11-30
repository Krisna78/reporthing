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
    }
}