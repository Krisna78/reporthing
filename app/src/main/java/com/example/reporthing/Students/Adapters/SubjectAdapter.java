package com.example.reporthing.Students.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;
import com.example.reporthing.Students.Models.Subjects.SubjectsData;
import com.example.reporthing.Students.SubjectDetailActivity;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.holder> {
    Context context;
    ArrayList<SubjectsData> arrayList = new ArrayList<>();
    public SubjectAdapter(Context context, ArrayList<SubjectsData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_subjects,parent,false);
        holder subjectHolder = new holder(view);
        return subjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        /*holder.nameSubject.setText(arrayList.get(position).getNamaMapel());
        holder.valueSubject.setText(arrayList.get(position).getNilaiRapor());
        holder.subjectDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubjectDetailActivity.class);
                intent.putExtra("subjectName",arrayList.get(position).getNamaMapel());
                intent.putExtra("semesters",arrayList.get(position).getSemester());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class holder extends RecyclerView.ViewHolder {
        TextView nameSubject,valueSubject;
        CardView subjectDetail;
        public holder(@NonNull View itemView) {
            super(itemView);
            nameSubject = itemView.findViewById(R.id.id_semester);
            valueSubject = itemView.findViewById(R.id.value_subject);
            subjectDetail = itemView.findViewById(R.id.subjct_list_name);
        }
    }
}
