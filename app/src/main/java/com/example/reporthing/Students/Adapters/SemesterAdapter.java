package com.example.reporthing.Students.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;
import com.example.reporthing.Students.Models.Semesters.SemesterData;
import com.example.reporthing.Students.StudentActivity;
import com.example.reporthing.Students.SubjectsActivity;

import java.util.ArrayList;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.holder> {
    Context context;
    ArrayList<SemesterData> arrayList = new ArrayList<>();
    public SemesterAdapter(Context context, ArrayList<SemesterData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SemesterAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_semester,parent,false);
        holder viewHolder = new holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterAdapter.holder holder, @SuppressLint("RecyclerView") int position) {
        holder.semesterName.setText("Semester "+arrayList.get(position).getSemester());
        holder.thnAjaran.setText("Tahun Ajaran "+ arrayList.get(position).getTahunAjaran());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubjectsActivity.class);
                intent.putExtra("nisn",arrayList.get(position).getNisn());
                intent.putExtra("semester",arrayList.get(position).getSemester());
                intent.putExtra("thn_ajaran",arrayList.get(position).getTahunAjaran());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class holder extends RecyclerView.ViewHolder {
        TextView semesterName,thnAjaran;
        CardView cardView;
        public holder(@NonNull View itemView) {
            super(itemView);
            semesterName = itemView.findViewById(R.id.idSemester);
            thnAjaran = itemView.findViewById(R.id.thn_ajaran);
            cardView = itemView.findViewById(R.id.cardSemester);
        }
    }
}
